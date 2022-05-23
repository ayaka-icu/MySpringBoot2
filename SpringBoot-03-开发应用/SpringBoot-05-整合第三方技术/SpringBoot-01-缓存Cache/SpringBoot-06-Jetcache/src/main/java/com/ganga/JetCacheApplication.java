package com.ganga;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//启用阿里的jetcache 缓存技术
@EnableCreateCacheAnnotation
//启用缓存方法 基于@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.ganga")
public class JetCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheApplication.class, args);
    }

}