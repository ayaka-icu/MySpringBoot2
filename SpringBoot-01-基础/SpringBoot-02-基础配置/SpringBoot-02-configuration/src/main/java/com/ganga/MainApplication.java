package com.ganga;

import com.ganga.config.MyDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(MainApplication.class, args);
		MyDataSource bean = cac.getBean(MyDataSource.class);
		System.out.println(bean);
	}

}
