package com.robinzhu.swagger2.utils;

import com.robinzhu.mybatis_plus.entity.Result;

/**
 * Create by zhudapeng
 * 2019-08-11 11:14
 * 返回结果处理工具集
 */
public class ResultUtil {
    public static Result success(Object data) {
        return new Result(0, null, data);
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, null);
    }
}
