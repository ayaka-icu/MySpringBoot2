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

        // 1200
        // PT1.2S
        // 1024B
        System.out.println("=========");
        System.out.println(serverConfig.getTimeOut());
        System.out.println("=========");
        System.out.println(serverConfig.getServerTimeOut01());
        System.out.println(serverConfig.getLogSize01());
        System.out.println("=========");
        System.out.println(serverConfig.getServerTimeOut02());
        System.out.println(serverConfig.getLogSize02());
        // =========
        // 1200
        // =========
        // PT1.2S
        // 1024B
        // =========
        // PT6H
        // 10485760B


    }

}
