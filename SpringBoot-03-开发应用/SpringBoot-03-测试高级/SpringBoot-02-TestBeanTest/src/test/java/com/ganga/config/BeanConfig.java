package com.ganga.config;

//测试时,有时会需要添加临时第三方的bean 使用测试类里加上Inport注解

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public String msg(){
        return "String Bean msg...";
    }

}
