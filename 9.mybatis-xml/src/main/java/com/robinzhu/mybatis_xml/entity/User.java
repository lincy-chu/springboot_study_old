package com.robinzhu.mybatis_xml.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private LocalDateTime userCreateTime;
    private LocalDateTime userUpdateTime;
}
