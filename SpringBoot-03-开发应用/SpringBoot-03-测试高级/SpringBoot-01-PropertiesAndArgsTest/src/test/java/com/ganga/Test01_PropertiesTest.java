package com.ganga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(properties = {"server.port=8888","ganga.hobby=原神"})
@ContextConfiguration(classes = Test01Application.class)
class Test01_PropertiesTest {

    @Value("${server.port}")
    private int port;
    @Value("${ganga.hobby}")
    private String hobby;

    @Test
    void properties() {

        System.out.println(port);
        System.out.println(hobby);

    }

}
