package com.robinzhu.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybatis的继承和使用
 *    mybatis是一款优秀的持久层框架，它支持定制化SQL，存储过程以及高级映射。mybatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集。mybatis可以使用简单的xml或注解来配置和映射原生信息，将接口和Java的POJOs（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录
 */

@SpringBootApplication
@Slf4j
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
        log.info("spring-boot-mybatis启动成功！");
    }
}
