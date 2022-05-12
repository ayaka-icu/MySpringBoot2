package com.ganga.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MP 配置类
 */
@Configuration
public class MPConfig {

    //引入第三方bean
    @Bean
    public MybatisPlusInterceptor setMybatisPlusInterceptor(){
        //创建MyBatisPlusInterceptor对象
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加内部的拦截器 PaginationInterceptor 分页器拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //interceptor.addInnerInterceptor(new a()); 添加更多的内部拦截器...

        return interceptor;
    }

}
