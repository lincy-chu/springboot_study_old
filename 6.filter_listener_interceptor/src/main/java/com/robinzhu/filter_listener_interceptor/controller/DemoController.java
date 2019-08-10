package com.robinzhu.filter_listener_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhudapeng
 * 2019-08-11 01:13
 */
@RestController
public class DemoController {
    @GetMapping("/")
    public String demo() {
        return "charter6";
    }
}
