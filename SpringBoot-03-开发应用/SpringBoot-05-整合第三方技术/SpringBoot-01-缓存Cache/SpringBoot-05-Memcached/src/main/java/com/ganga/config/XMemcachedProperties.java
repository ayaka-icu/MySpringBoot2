package com.ganga.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {

    //配置连接地址和端口号
    private String servers;

    //设置最大连接数量
    private Integer poolSize;

    //设置超时时间
    private Long opTimeout;


}
