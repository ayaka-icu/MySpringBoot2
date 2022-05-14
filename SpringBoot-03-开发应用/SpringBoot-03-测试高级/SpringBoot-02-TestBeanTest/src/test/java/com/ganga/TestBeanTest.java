package com.ganga;

import com.ganga.config.BeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({BeanConfig.class}) //导入临时配置类 加载bean
class TestBeanTest {

    @Autowired
    private String msg;

    @Test
    void contextLoads() {
        System.out.println(msg);
    }

}
