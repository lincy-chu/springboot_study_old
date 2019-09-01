package com.robinzhu.mybatis_plus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    @Bean
//    public ISqlInjector sqlInjector() { // 注册sqlInjector，3.1.1之后不需要注册，对于3.1.1以下的如果没有注册这个Bean则逻辑删除不生效（为物理删除）
//        return new LogicSqlInjector();
//    }
}
