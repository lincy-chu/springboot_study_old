package com.robinzhu.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Create by zhudapeng
 * 2019-08-17 11:30
 */
@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartResolver custom() {
        return new CommonsMultipartResolver();
    }
}
