package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Create by zhudapeng
 * 2019-09-08 20:27
 * 订单接口
 */
@Mapper
@Component
public interface OrderMapper {
    /**
     * 根据订单号查询订单及用户信息
     * @param orderNo
     * @return
     */
    Order queryOrderWithUserByOrderNo(@Param("orderNo") String orderNo);

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 一对多：查询订单，查询出下单人信息并且查询出订单详情
     * 根据订单号查询订单用户的信息及订单详情
     * @param orderNo
     * @return
     */
    Order queryOrderWithUserAndDetailByOrderNo(@Param("orderNo") String orderNo);
}
