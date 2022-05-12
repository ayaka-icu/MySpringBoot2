package com.ganga;

import com.ganga.config.ServerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerConfigTests {

    @Autowired
    private ServerConfig serverConfig;

    @Test
    void contextLoads() {

        System.out.println(serverConfig.getIpAddress());
        System.out.println(serverConfig.getPort());
        System.out.println(serverConfig.getTimeOut());

    }

}
