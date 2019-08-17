package com.robinzhu.skills.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhudapeng
 * 2019-08-17 12:25
 * @CrossOrigin(origins, allowedHeaders, methods, exposedHeaders, allowCredentials, maxAge)
 *  origins：允许的来源列表，它的值放置在HTTP协议的响应header的Access-Control-Allow-Origin。
 *      *：意味着所有的源是被允许的。
 *      如果未定义，则允许所有来源
 *  allowedHeaders：实际请求期间可以使用的请求标头列表。值用于预检的响应header Access-Control-Allow-Headers
 *      *：意味着允许客户端请求的所有头文件
 *      如果未定义，则允许所有请求的headers
 *  methods：支持的HTTP请求方法列表，如果未定义，则使用由RequestMapping注释定义的方法
 *  exposedHeaders：浏览器允许客户端访问的响应头列表，在实际响应报头Access-Control-Expose-Headers中设置值
 *      如果未定义，则使用空的暴露标题列表
 *  allowCredentials：它确定浏览器是否应该包含与请求相关的任何cookie。
 *      false：cookies不应该包含在内
 *      ""：（空字符串）以为着未定义
 *      true：预响应将包括值设置为true的报头Access-Control-Allow-Credentials
 *      如果未定义，则允许所有凭据
 *  maxAge：预响应的高速缓存持续时间的最大时间（以秒为单位）。值在标题Access-Control-Max-Age中设置
 *      如果未定义，最大时间设置为1800秒（30分钟）
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class crossOriginController {
    @CrossOrigin(origins = "http://example.com") // index()方法只能从域http://example.com访问。其他方法早crossOriginController中将可以从所在域访问
    @GetMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "跨域设置");
        return map;
    }
}
