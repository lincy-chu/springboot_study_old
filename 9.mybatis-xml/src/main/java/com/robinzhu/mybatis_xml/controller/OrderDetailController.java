package com.robinzhu.mybatis_xml.controller;

import com.robinzhu.mybatis_xml.entity.OrderDetail;
import com.robinzhu.mybatis_xml.entity.Result;
import com.robinzhu.mybatis_xml.mapper.OrderDetailMapper;
import com.robinzhu.mybatis_xml.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhudapeng
 * 2019-09-08 23:30
 * 订单详情
 */
@RestController
@RequestMapping(value = "/order/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailMapper odMapper;

    @GetMapping(value = "/getOrderDetailById")
    public Result getOrderDetailById(@Param("id") String id) {
        OrderDetail orderDetail = odMapper.getOrderDetailById(id);
        return ResultUtil.success(orderDetail);
    }

    @PostMapping(value = "/insertOrderDetail")
    public Result insertOrderDetail(OrderDetail orderDetail) {
        odMapper.insert(orderDetail);
        return ResultUtil.success();
    }
}
