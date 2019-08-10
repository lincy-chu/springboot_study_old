package com.robinzhu.filter_listener_interceptor.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Create by zhudapeng
 * 2019-08-11 01:16
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器 拦截规则
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public static HandlerInterceptor getHandlerInterceptor() {
        return new CustomHandlerInterceptor(); // 引用自动以拦截器
    }
}
