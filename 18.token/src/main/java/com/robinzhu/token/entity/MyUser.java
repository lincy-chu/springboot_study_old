package com.robinzhu.token.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by zhudapeng
 * 2019-08-23 23:04
 * 更多spring boot注解见：https://www.cnblogs.com/ldy-blogs/p/8550406.html
 */
@Data
@AllArgsConstructor // 注解在类上，为类提供一个全参的构造方法
@NoArgsConstructor // 注解在类上，为类提供一个无参的构造方法
public class MyUser {
    String Id;
    String username;
    String password;
}
