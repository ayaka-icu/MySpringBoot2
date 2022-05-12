package com.ganga.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component //在使用EnableConfigurationProperties指定后 已经注入 这了在注入会报错
@ConfigurationProperties(prefix = "ganga") ////这里不能用大写 ！！！
public class ServerConfig {

    private String ipAddress;
    private int port;
    private String prefix;

}
