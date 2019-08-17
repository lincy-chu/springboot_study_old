package com.robinzhu.skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 原来我们在使用tomcat开发时，设置网站图片时，即icon图标时，一般都是直接替换root包下favicon.ico替换成自己的，或者在网页的头部设置link的ref为icon然后设置其href值。而在springboot中，替换图片也很简单，只需要将自定义图片放置在静态资源目录下即可，即默认下static、public、resources、/META-INF/resources或者自定义的静态目录下即可
 */
@SpringBootApplication
public class SkillsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillsApplication.class, args);
    }
}
