package com.robinzhu.filter_listener_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 过滤器、监听器、拦截器
 *    在实际开发过程中，经常会碰见一些比如系统启动初始化信息、统计在线人数、在线用户数、过滤敏感词汇、访问权限控制（URL级别）等业务需求。这些对业务来说一般上是无关的，业务方是无需关心的，业务只需要关心自己内部业务的事情，所以一般上实现以上的功能，都会或多或少的用到过滤器、监听器、拦截器来实现以上功能。
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class FilterListenerInterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterListenerInterceptorApplication.class, args);
        log.info("charter6服务启动");
    }
}
