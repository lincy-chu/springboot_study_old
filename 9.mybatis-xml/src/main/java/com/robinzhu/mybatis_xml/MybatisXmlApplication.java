package com.robinzhu.mybatis_xml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MybatisXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlApplication.class, args);
        log.info("spring-boot-mybatis启动成功！");
    }
}
