package com.robinzhu.mybatis.config;

import com.robinzhu.mybatis.enums.StatusEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by zhudapeng
 * 2019-08-11 21:04
 */
@Configuration
//@MapperScan(value = "com.robinzhu.mybatis.mapper") // 指定mapper扫描包路径地址
@MapperScan(value = "com.robinzhu.mybatis.xmlMapper") // 指定mapper扫描包路径地址
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        ConfigurationCustomizer config = new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                typeHandlerRegistry.register(StatusEnum.class, EnumOrdinalTypeHandler.class);
            }
        };
        return config;
    }
}
