package com.ganga;

import com.ganga.config.MyDataSource;
import com.ganga.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//EnableConfigurationProperties 指定要使用配置类 并 放入Sprng容器当中
//注意:这里添加了这个注解后 里面类已经放入了Spring容器里了 原有类在添加@Component会报错
//但是@ConfigurationProperties(prefix = "ganga") /... 依然不能少
@EnableConfigurationProperties({
        ServerConfig.class,MyDataSource.class
})
public class ConfigurationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext cac = SpringApplication.run(ConfigurationApplication.class, args);

        ServerConfig bean = cac.getBean(ServerConfig.class);
        System.out.println(bean);
        //ServerConfig(Address=192.168.0.1, port=6666, prefix=/ganga)

        MyDataSource bean1 = cac.getBean(MyDataSource.class);
        System.out.println(bean1);
        //MyDataSource(driver=com.mysql.jdbc.Driver, url=jdbc:mysql:///xxx?xxx=xxx&xxx=xxx, name=ganga, password=666)

    }

}
