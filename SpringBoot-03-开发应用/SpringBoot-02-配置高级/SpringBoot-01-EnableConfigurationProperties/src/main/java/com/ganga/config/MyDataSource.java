package com.ganga.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//放入容器当中
//@Component //在使用EnableConfigurationProperties指定后 已经注入 这了在注入会报错
@ConfigurationProperties(prefix = "mydatasource") //这里不能用大写 ！！！
public class MyDataSource {

    private String driver;
    private String url;
    private String name;
    private String password;

}
