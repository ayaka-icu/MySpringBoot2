package com.ganga;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ESTests {


    private RestHighLevelClient client;

    /**
     * 创建客户端
     */
    @BeforeEach
    void before(){
        //创建客户端
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    /**
     * 关闭客户端
     * @throws IOException
     */
    @AfterEach
    void after() throws IOException {
        //关闭客户端
        client.close();
    }



    /**
     * 客户端操作
     */
    @Test
    void test() throws IOException {

        //客户端操作
        CreateIndexRequest request = new CreateIndexRequest("book");

        //获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request, RequestOptions.DEFAULT);

    }




}
