package com.robinzhu.helloword.controller;

import com.robinzhu.helloword.enity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Spring Boot的核心功能
 * 1.独立运行的Spring项目
 *   Spring Boot可以以jar包的形式独立运行，运行一个Spring Boot项目只需要通过Java-jar xx.jar
 * 2.内置Servlet容器
 *   Spring Boot可选择内嵌Tomcat、Jetty或者Undertow，这样无需以war包形式部署
 * 3.提供starter简化maven配置
 *   Spring Boot提供了一系列的starter pom来简化maven依赖加载
 * 4.自动配置
 *   Spring boot会根据类路径中的jar包、类，为jar包里的类自动配置Bean，这样会极大的减少要使用的配置
 * 5.无代码生成和xml配置
 *   Spring Boot的神奇不是借助于代码生成来实现的，而是通过条件注释来实现的。Spring 4.x提倡使用Java配置和注释配置相结合，而spring boot不需要任何xml配置即可实现spring boot的所有配置
 *
 * 优缺点
 * 1.优点
 *   1.快速构建项目：省略了繁琐且复杂的xml配置，快速构建web项目
 *   2.对主流开发框架的无配置集成：提供了很多starter依赖包，开箱即用，无需多余配置
 *   3.项目可独立运行：无需外部依赖的Servlet容器
 *   4.极大地提高了开发、部署效率
 *   5.监控简单：提供了actuator包，可用来对应用进行监控
 * 2.缺点
 *   1.依赖太多：一个简单的SpringBoot应用都有好几十M
 *   2.缺少监控方案、安全管理方案：只提供基础监控，要实现生产级别的监控，监控方案需要自己动手解决
 *
 */
@RestController // @RestController = @Controller + @ResponseBody 默认直接返回json
public class HelloController {
    @GetMapping(value = "/")
    public User hello() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("多多");
        user.setPassword("robin.zhu");
        return user;
    }
}
