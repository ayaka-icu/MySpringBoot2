package com.ganga;

import com.ganga.controller.DameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 这是一个引导类
 *      要想使用Spring 就必须有一个核心 IOC
 *      控制反转！
 *
 *      SpringApplication.run(); 返回一个应用程序上下文 ApplicationContext
 */
@SpringBootApplication
public class 引导类 {

    //引导类main
    public static void main(String[] args) {

        //创建Spring IOC 容器
        ConfigurableApplicationContext app = SpringApplication.run(引导类.class, args);

        //尝试从IOC 容器当中获取响应的bean对象
        DameController dameController = app.getBean(DameController.class);
        System.out.println("\ndameController ===> " + dameController);

        //对于Spring中的组件扫描
        /**
         * SpringBootApplication注解源码:
         *
         * @ComponentScan(
         *     excludeFilters = {@Filter(
         *     type = FilterType.CUSTOM,
         *     classes = {TypeExcludeFilter.class}
         * ), @Filter(
         *     type = FilterType.CUSTOM,
         *     classes = {AutoConfigurationExcludeFilter.class}
         * )}
         * )
         *
         */
        //默认是在该类的 所在包 及其 子包下 进行扫描的！


        //关于内置服务器
        //SpringBoot 提供了3个内置服务器：Tomcat Jetty Undertow 默认是Tomcat
        /**
         *
         * SpringBoot内置服务器的运行不是将 项目放入服务器当中
         * 而是将 服务器对象放入 Spring IOC容器当中！
         *
         * 服务器对象：如Tomcat服务器 tomcat归根使用java源码写的 在JVM当中运行
         *          所以 Spring将其抽取为一个对象 将这个对象放入Spring IOC容器当中
         *          通过容器进行相应地操作是Spring熟练的！
         *
         */

    }

}
