package com.ganga;

import com.ganga.controller.BrandController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//开启web测试环境 随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//注入模拟mvc对象
@AutoConfigureMockMvc
class WebTests {

    //测试响应状态
    @Test  //注入MockMvc对象 如果类前没有加@AutoConfiguraMockMvc 则容器中没有MockMvc对象
    void statusTest(@Autowired MockMvc mockMvc) throws Exception {

        //定义执行请求方式 和请求路径
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete(/*"/brands"*/"/brand");
        //执行虚拟请求
        ResultActions perform = mockMvc.perform(builder);//执行这个 请求

        //匹配请求状态 是否是预期值
        //定义状态匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher is = status.isOk()/*.is(200)*/;
        //本次执行结果:perform 与 预期结果：is 做对比
        perform.andExpect(is); //黑盒测试

        /*java.lang.AssertionError: Status expected:<200> but was:<404>
        * 预期:200
        * 实际:404
        *  */
    }


    //测试响应体
    @Test
    public void content(@Autowired MockMvc mockMvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/brands");
        ResultActions perform = mockMvc.perform(builder);

        ContentResultMatchers matcher = MockMvcResultMatchers.content();
        //把响应体数据 准换为字符串进行比较
        ResultMatcher is = matcher.string("SpringBoot2 getById is running..." /*"SpringBoot getById is running..."*/);

        perform.andExpect(is);


        /*  java.lang.AssertionError: Response content expected:<SpringBoot2 getById is running...> but was:<SpringBoot getById is running...>
            预期:SpringBoot2 getById is running...
            实际:SpringBoot getById is running...
        */

    }

    //测试响应体 json数据
    @Test
    public void contentJsonTest(@Autowired MockMvc mockMvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/brands");
        ResultActions perform = mockMvc.perform(builder);

        ContentResultMatchers matcher = MockMvcResultMatchers.content();
        ResultMatcher is = matcher.json("{\n" +
                "    \"id\": 1,\n" +
                "    \"brandName\": \"SpringBoot2 setBrandName\",\n" +
                "    \"companyName\": \"SpringBoot setCompanyName\",\n" +
                "    \"ordered\": 1,\n" +
                "    \"description\": \"SpringBoot setDescription\"\n" +
                "}");

        perform.andExpect(is);

        /* java.lang.AssertionError: brandName
           Expected: SpringBoot2 setBrandName
           got: SpringBoot setBrandName
       */
    }


    //测试响应头
    @Test
    public void headerTest(@Autowired MockMvc mockMvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/brands");
        ResultActions perform = mockMvc.perform(builder);

        HeaderResultMatchers matcher = MockMvcResultMatchers.header();
        //string(参数一,参数二)  参数一：响应头名称  参数二：对应响应头的值
        ResultMatcher is = matcher.string("content-Type", "application/json");
        perform.andExpect(is);

    }


    //模拟实际开发中...
    @Test
    public void getByIdTest(@Autowired MockMvc mockMvc) throws Exception {

        //模拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/brands");
        ResultActions perform = mockMvc.perform(builder);

        //测试请求状态是否预期
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher is = status.isOk();
        perform.andExpect(is);

        //测试响应头是否预期
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher type = header.string("content-Type", "application/json");
        perform.andExpect(type);

        //测试响应数据是否预期
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\n" +
                "    \"id\": 1,\n" +
                "    \"brandName\": \"SpringBoot setBrandName\",\n" +
                "    \"companyName\": \"SpringBoot setCompanyName\",\n" +
                "    \"ordered\": 1,\n" +
                "    \"description\": \"SpringBoot setDescription\"\n" +
                "}");
        perform.andExpect(json);

        //测试......是否预期

        //测试的越多 精准  测试多少取决于公司...

    }


}
