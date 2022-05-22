package com.ganga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//第二步: 在容器中开启缓存
@EnableCaching
public class MemcachedApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemcachedApplication.class, args);
    }

}