package com.robinzhu.swagger2.entity;

import lombok.Data;

/**
 * Create by zhudapeng
 * 2019-08-11 10:36
 */
@Data
public class CommonException extends RuntimeException {
    private Integer code;
    private String msg;
    private Object data;

    public CommonException(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
