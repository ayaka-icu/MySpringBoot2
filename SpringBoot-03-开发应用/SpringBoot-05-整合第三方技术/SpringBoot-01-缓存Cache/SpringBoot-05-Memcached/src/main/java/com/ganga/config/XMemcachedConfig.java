package com.ganga.config;


import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * 手动创建memcached 客户端
 */
@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties properties;

    @Bean
    public MemcachedClient getXMemcachedClient() throws IOException {

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(properties.getServers());
        builder.setConnectionPoolSize(properties.getPoolSize());
        builder.setOpTimeout(properties.getOpTimeout());

        MemcachedClient memcachedClient = builder.build();
        return memcachedClient;
    }

}
