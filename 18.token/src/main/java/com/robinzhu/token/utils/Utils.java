package com.robinzhu.token.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.robinzhu.token.entity.MyUser;

/**
 * Create by zhudapeng
 * 2019-08-23 23:15
 */
public class Utils {
    public static String getToken(MyUser user) {
        /**
         * Algorithm.HMAC256()：使用HS256生成token，密钥则是用户的密码，唯一密钥的话可以保存在服务端
         * withAudience()：存入需要保存在token的信息，这里把用户id存入token中
         */
        return JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
    }
}
