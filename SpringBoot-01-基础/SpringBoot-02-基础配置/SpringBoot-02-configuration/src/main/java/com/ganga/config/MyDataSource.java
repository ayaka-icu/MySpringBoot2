package com.ganga.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("myDataSource") //要把这个对象放入到容器当中
@ConfigurationProperties(prefix = "datasource") //指定自定义对象封装指定数据
//datasource是yaml文件当中的属性 prefix是前缀
public class MyDataSource {

    /**
     * yaml文件中datasource 里的属性要与
     *      这里的成员变量名对应
     *      如果没有对应的
     *      则这个成员变量的值为 null
     */
    private String driver;
    private String url;
    private String username;
    private String password;

}