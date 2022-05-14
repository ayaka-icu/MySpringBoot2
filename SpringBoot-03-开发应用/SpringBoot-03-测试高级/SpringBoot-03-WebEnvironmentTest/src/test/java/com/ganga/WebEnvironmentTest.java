package com.ganga;

import com.ganga.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) //默认就是none 不开启
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //根据配置文件进行加载端口 开启web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //开启web环境 并 随机不占用端口 推选使用这个
class WebEnvironmentTest {

    @Test
    void contextLoads(@Autowired TestController testController) {

        testController.me();

    }

}
