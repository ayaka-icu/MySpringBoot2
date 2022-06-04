package com.ganga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestBeanApplication.class, args);

        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }

    }

}
