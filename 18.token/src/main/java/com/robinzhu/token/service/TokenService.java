package com.robinzhu.token.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.robinzhu.token.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create()
                .withIssuer("robin.zhu") // 发行者
                .withSubject("userId") // 用户身份标识
                .withAudience(user.getId()) // 用户单位（此处为userId）
                .withIssuedAt(new Date()) // 签发时间（此处为当前时间）
                .withExpiresAt(new Date(new Date().getTime() + 60 * 1000L))
                .withJWTId("0001") // 分配JWT的Id
                .withClaim("PublicClaimExample", "You should not pass") // 定义公共域信息
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
