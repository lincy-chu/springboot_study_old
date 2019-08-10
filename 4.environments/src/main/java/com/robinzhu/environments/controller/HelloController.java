package com.robinzhu.environments.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @Value("${profile}")
    private String profile;

    @GetMapping("/")
    public Map<String, Object> Hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("profile", profile);
        return map;
    }
}
