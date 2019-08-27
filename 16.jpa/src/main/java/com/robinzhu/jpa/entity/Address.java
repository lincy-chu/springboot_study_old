package com.robinzhu.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Create by zhudapeng
 * 2019-08-27 21:27
 * 地址类
 */
@Data
@NoArgsConstructor // 注释在类上，为类提供一个无参的构造函数
@Embeddable        // 表示一个嵌入类，这个类的对象在另一个实体类中充当属性
public class Address {
    private String postCode; // 邮编
    private String address;  // 地址
    private String phone;    // 联系电话

    public Address(String postCode, String address, String phone) {
        this.postCode = postCode;
        this.address = address;
        this.phone = phone;
    }
}
