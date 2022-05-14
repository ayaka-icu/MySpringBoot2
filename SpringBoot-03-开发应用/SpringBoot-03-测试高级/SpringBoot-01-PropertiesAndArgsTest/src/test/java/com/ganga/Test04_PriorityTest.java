package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//根据优先级 args 程序参数入口的属性值 要大于配置文件级别
@SpringBootTest(properties = "server.port=6666",args = "--server.port=9999")
@ContextConfiguration(classes = Test01Application.class)
public class Test04_PriorityTest {

    @Value("${server.port}")
    private int port;

    @Test
    void PriorityTest(){
        System.out.println("port===>" + port);
    }


}
