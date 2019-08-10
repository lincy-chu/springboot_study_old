package com.robinzhu.config.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-09 22:37
 */
@Component
@ConfigurationProperties(prefix = "config")
@Data
public class Config {
    private String code;
    private String name;
    private List<String> hobby;
}
