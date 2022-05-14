package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//程序入口参数 属性前加 --
@SpringBootTest(args = {"--server.port=6666","--ganga.hobby=这就尴尬了"})
@ContextConfiguration(classes = Test01Application.class)
public class Test02_ArgsTest {

    @Value("${server.port}")
    private int port;
    @Value("${ganga.hobby}")
    private String hobby;

    @Test
    void argsTest(){

        System.out.println(port);
        System.out.println(hobby);

    }

}
