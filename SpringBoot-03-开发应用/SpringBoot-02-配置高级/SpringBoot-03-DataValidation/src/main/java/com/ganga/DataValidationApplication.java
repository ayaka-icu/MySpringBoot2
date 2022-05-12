package com.ganga;

import com.ganga.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ServerConfig.class
})
public class DataValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataValidationApplication.class, args);
    }
}
