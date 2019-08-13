package com.robinzhu.mybatis_plus.entity;

import lombok.Data;

/**
 * Create by zhudapeng
 * 2019-08-11 10:36
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
