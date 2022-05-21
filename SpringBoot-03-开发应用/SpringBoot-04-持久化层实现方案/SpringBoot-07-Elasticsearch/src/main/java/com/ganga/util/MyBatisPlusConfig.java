package com.ganga.util;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MybatisConfig
 * @author: dyh
 * @since: 2022/1/28 18:03
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {

        //创建MyBatisPlusInterceptor对象
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加内部的拦截器 PaginationInterceptor 分页器拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //interceptor.addInnerInterceptor(new a()); 添加更多的内部拦截器...

        return interceptor;
    }
}