package com.robinzhu.comment.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String id;
    private String userName;
    private String password;

    public User() {}

    public User(String id, String userName, String password) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
