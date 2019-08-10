package com.robinzhu.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot常用注释介绍及简单实用
 *  由于Spring Boot本身是基于Spring和SpringMvc等类spring家族的一个解决方案，可快速进行集合
 */

/**
 * @SpringBootApplication 启动注解，这个注解是个组合注释，包括了@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan注解
 *
 * @SpringBootConfiguration 继承至@Configuration，对于熟悉spring的开发者而言，此标注当前类是配置类，并会将当前类声明一个或多个以@Bean注解标记的方法的实例纳入到Spring容器中，并且实例名就是方法名
 *
 * @EnableAutoConfiguration 这个注解就是springboot能自动进行配置的魔法所在。主要是通过此注释，能所有符合自动配置条件的bean的定义加载到spring容器中，比如根据spring-boot-starter-web，来判断你的项目是否需要添加了webmvc和tomcat，就会自动的帮你配置web项目中所需要的默认配置。
 *
 * @ComponentScan ，会扫描当前包及其子包下被@Component，@Controller，@Service，@Repository等注解标记的类来纳入到spring容器中进行管理
 */
@SpringBootApplication
public class CommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }
}
