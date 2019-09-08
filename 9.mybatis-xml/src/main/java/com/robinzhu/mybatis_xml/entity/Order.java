package com.robinzhu.mybatis_xml.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-09-08 19:52
 * 订单表
 * 高级功能
 * 1.表关系说明
 *     mybatis作为一个ORM框架，也对SQL的高级查询做了支持
 *     案例说明：
 *     此案例的业务关系是用户、订单、订单详情、商品之间的关系，其中：一个订单只能属于一个人；一个订单可以有多个订单详情；一个订单详情中包含一个商品信息
 *     它们的关系是：订单和人是一对一的关系；订单和订单详情是一对多的关系；订单和商品是多对多的关系。
 *     需求说明：
 *         一对一查询：查询订单，并且查询出下单人的信息
 *         一对多查询：查询订单，查询出下单人信息并且查询出订单详情
 *         多对多查询：查询订单，查询出订单人信息并且查询出订单详情中的商品数据
 * 2.一对一查询
 *     方法一：核心思想扩展Order对象，来完成映射
 */
@Data
public class Order {
    // 订单id
    private String id;
    // 用户id
    private String userId;
    // 订单号
    private String orderNumber;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
    // 用户
    private User user;
    // 订单详情列表
    private List<OrderDetail> detailList;
}
