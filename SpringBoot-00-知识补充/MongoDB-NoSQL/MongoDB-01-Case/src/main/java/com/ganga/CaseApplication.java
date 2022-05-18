package com.ganga;

import com.ganga.dao.CommentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CaseApplication.class);

        System.out.println(run.getBean(CommentRepository.class));
        System.out.println("==============");
        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        for (String x : beanDefinitionNames) {
            System.out.println(x);
        }

    }

}
