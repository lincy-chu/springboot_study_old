package com.robinzhu.mybatis_xml.entity;

import lombok.Data;

/**
 * Create by zhudapeng
 * 2019-09-08 22:42
 */
@Data
public class OrderDetail {
    // 详情id
    private String id;
    // 订单id
    private String orderId;
    // 总价
    private Double totalPrice;
    // 订单状态
    private Integer status;
}
