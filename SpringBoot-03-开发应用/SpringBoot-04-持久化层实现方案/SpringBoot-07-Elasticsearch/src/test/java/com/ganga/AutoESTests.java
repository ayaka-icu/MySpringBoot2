package com.ganga;

import com.alibaba.fastjson.JSON;
import com.ganga.pojo.Brand;
import com.ganga.server.BrandService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class AutoESTests {

    //SpringBoot 2.6.x版本 已经可以 自动注入 RestHighLevelClient 高级客户端对象了
    @Autowired
    private RestHighLevelClient client;

    /**
     * 添加索引
     * @throws IOException
     */
    @Test
    void autoTest() throws IOException {
        //客户端操作
        org.elasticsearch.client.indices.CreateIndexRequest request = new CreateIndexRequest("bookk");

        //获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    void delTest() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("brands");
        client.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
    }


    /**
     * 创建索引 设置属性 设置分词器
     */
    @Test
    void indexTest() throws IOException {

        CreateIndexRequest request = new CreateIndexRequest("brands");

        String json = "{\n" +
                "  \"mappings\": {\n" +
                "    \"properties\": {\n" +
                "      \"id\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"brandName\": {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\",\n" +
                "        \"copy_to\": \"all\"\n" +
                "      },\n" +
                "      \"companyName\": {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\",\n" +
                "        \"copy_to\": \"all\"\n" +
                "      },\n" +
                "      \"ordered\": {\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"description\":{\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\",\n" +
                "        \"copy_to\": \"all\"\n" +
                "      },\n" +
                "      \"status\":{\n" +
                "        \"type\": \"keyword\"\n" +
                "      },\n" +
                "      \"all\": {\n" +
                "        \"type\": \"text\",\n" +
                "        \"analyzer\": \"ik_max_word\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        //给这个对象添加 source方法
        request.source(json, XContentType.JSON);

        client.indices().create(request,RequestOptions.DEFAULT);

    }

    /**
     * 该文档添加数据 单个文档
     */
    @Test
    void createDocTest(@Autowired BrandService brandService){

        //先从数据库中查询相应数据
        Brand brand = brandService.getById(1);
        System.out.println(brand);

        //放入ES
        IndexRequest request = new IndexRequest("brands").id(brand.getId());

        //使用source 放入数据
        String json = JSON.toJSONString(brand);
        System.out.println(json);
        request.source(json,XContentType.JSON);

        //这里异常不影响 版本问题
        try {
            client.index(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 添加所有文档 批处理
     */
    @Test
    void createDocAllTest(@Autowired BrandService brandService){

        List<Brand> brands = brandService.list();
        System.out.println(brands);
        BulkRequest request = new BulkRequest();

        for (Brand brand : brands) {
            IndexRequest ir = new IndexRequest("brands").id(brand.getId());
            ir.source(JSON.toJSONString(brand),XContentType.JSON);
            request.add(ir);
        }

        try {
            //bulk方法
            client.bulk(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据id删除文档
     */
    @Test
    void deleteByIdTest(){

        DeleteRequest request = new DeleteRequest("brands").id("17");

        try {
            //delete方法
            client.delete(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询文档 通过id查询
     */
    @Test
    void getDoc() throws IOException {


        GetRequest request = new GetRequest("brands").id("3");

        //使用get方法
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        //getSourceAsString方法 返回的是json字符串
        String json = response.getSourceAsString();

        System.out.println(json);

        Brand brand = JSON.parseObject(json, Brand.class);
        System.out.println(brand);
    }


    /**
     * 查询文档 通过条件查询
     */
    @Test
    void getDocSearch() throws IOException {


        SearchRequest request = new SearchRequest("brands");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        //builder.query(QueryBuilders.matchPhraseQuery("brandName","崩坏"));
        builder.query(QueryBuilders.matchQuery("all","技术"));

        request.source(builder);

        SearchResponse search = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            String x = hit.getSourceAsString();
            System.out.println(x);
        }
    }


}
