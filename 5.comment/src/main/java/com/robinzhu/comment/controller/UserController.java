package com.robinzhu.comment.controller;

import com.robinzhu.comment.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Controller和@RestController
 *  @RestController是Spring4之后加入的注释，原来在@Controller中返回json需要@ResponseBody来配合，如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。而@Controller是用来创建处理http请求的对象，一般结合@RequestMapping使用
 *
 * @RequestMapping
 *  一个用来请求地址映射的注释，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
 *  常用属性：
 *      value: 指定请求的实际地址，指定地址可以是url template模式
 *      method：指定请求的method类型，GET、POST、PUT、DELETE等
 *      consumes：指定请求的提交类型形式（Content-Type），例如：application/json，text/html
 *      produces：指定返回的内容类型，仅当request请求头中类型中包含该指定类型才返回
 *      params：指定request中必须包含某些参数值时，才让该方法处理
 *      headers：指定request中必须包含某些指定的header值，才能让该方法处理请求
 */
@RestController
public class UserController {
    @GetMapping("/")
    public Map<String, Object> userList() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<User> userList = new ArrayList<User>();
        for (int j = 0; j < 5; j++) {
            User user = new User(UUID.randomUUID().toString().replace("-", ""), "朱大鹏", "robin123");
            userList.add(user);
        }
        map.put("code", 0);
        map.put("msg", null);
        map.put("data", userList);
        return map;
    }
}
