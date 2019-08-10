package com.robinzhu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 在多数情况下，配置信息基本上都是放入application.properties文件中，但在一些场景下，比如某个配置项比较多时，为了分开存在，也可以自定义配置文件，如my.properties。由于自定义的文件，系统不会自动加载，这个时候就需要手动引入。利用@PropertySource注释既可以引入配置文件(仅限扩展名为properties的文件，如有属性为中文需要设置其encoding为utf-8)，需要引入多个时，可使用@PropertySources设置数组，引入多个文件
 */
@SpringBootApplication
@PropertySource(value = "classpath:config.properties", encoding = "utf-8") // 非默认的配置文件需先导入才能整体（通过prefix）引入
//@PropertySources({@PropertySource(value = "classpath:b.properties", encoding = "utf-8"), @PropertySource(value = "classpath:c.properties", encoding = "utf-8")})
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
