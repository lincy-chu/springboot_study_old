package com.robinzhu.config.controller;

import com.robinzhu.config.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhudapeng
 * 2019-08-09 21:34
 */
@RestController
public class DemoController {
    @Autowired
    private Config config;

    @Value("${blog.address}")
    private String address;

    @Value("${blog.author}")
    private String author;

    @Value("${blog.desc}")
    private String desc;

    @Value("${blog.test1}")
    private Integer test1;

//    @Value("${c.city}")
    private String city;

    @GetMapping("/")
    public Map<String, Object> demo() {
        Map<String, Object> map = new HashMap<>();
        map.put("desc", desc);
        map.put("config", config);
        return map;
    }
}
