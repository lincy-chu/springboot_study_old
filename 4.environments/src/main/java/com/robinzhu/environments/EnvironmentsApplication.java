package com.robinzhu.environments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot多环境支持
 *  profile是Spring针对不同环境不同配置的支持。需要满足application-{profile}.yml, {profile}对应你的环境标识
 *  如：application-dev.yml：开发环境
 *     application-test.yml：测试环境
 *  而制定执行哪份配置文件，只需要在application.yml配置spring.profiles.active为对应${profiles}的值
 */
@SpringBootApplication
public class EnvironmentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnvironmentsApplication.class, args);
    }
}
