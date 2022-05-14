package com.ganga.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "testcase.student")
public class TestCase {

    //会自动注入
    private int id;
    private int id2;
    private int id3;
    private int id4;
    private int id5;
    private String name;
    private String name2;
    private String uuid;
    private long time;

}
