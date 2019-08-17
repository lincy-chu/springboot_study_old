package com.robinzhu.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springMVC中利用multipartFile进行文件上传，而MultipartFile是一个接口类，它的实现类有CommonsMultipartFile和StandardMultipartFile。
 * StandardMultipartFile：是基于j2ee自带的文件上传进行解析，集使用servlet3.0提供的javax.servlet.http.Part上传方式
 * CommonsMultipartFile：是基于apache fileupload.
 * 正常我们使用时，也是无需关心底层是进行哪种方式进行文件上传处理的，SpringMVC会给我们进行相应的转换
 */
@SpringBootApplication
public class UploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }

}
