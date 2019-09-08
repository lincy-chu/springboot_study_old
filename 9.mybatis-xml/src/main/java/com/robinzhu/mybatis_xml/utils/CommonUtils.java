package com.robinzhu.mybatis_xml.utils;

import java.util.UUID;

/**
 * Create by zhudapeng
 * 2019-09-08 22:07
 * 公共工具类
 */
public class CommonUtils {
    public static String bornOrderNo() {
        String orderNo = UUID.randomUUID().toString().replace("-", "");
        return orderNo;
    }
}
