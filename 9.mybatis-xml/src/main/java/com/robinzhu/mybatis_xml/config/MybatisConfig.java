package com.robinzhu.mybatis_xml.config;

import com.robinzhu.mybatis_xml.enums.SexEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by zhudapeng
 * 2019-09-08 11:12
 * mybatis配置
 */

@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        ConfigurationCustomizer config = new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                TypeHandlerRegistry handlerRegistry = configuration.getTypeHandlerRegistry();
                handlerRegistry.register(SexEnum.class, EnumOrdinalTypeHandler.class);
            }
        };
        return config;
    }
}
