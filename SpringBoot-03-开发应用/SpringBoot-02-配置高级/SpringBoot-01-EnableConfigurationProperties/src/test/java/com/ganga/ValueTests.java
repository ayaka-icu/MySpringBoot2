package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValueTests {

    //@Value("${ganga.ipAddress}")
    @Value("${ganga.ip-address}")
    private String ip;

    @Test
    void contextLoads() {

        System.out.println(ip);

    }

}
