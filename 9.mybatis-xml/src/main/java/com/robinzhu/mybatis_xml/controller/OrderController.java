package com.robinzhu.mybatis_xml.controller;

import com.robinzhu.mybatis_xml.entity.Order;
import com.robinzhu.mybatis_xml.entity.Result;
import com.robinzhu.mybatis_xml.entity.User;
import com.robinzhu.mybatis_xml.mapper.OrderMapper;
import com.robinzhu.mybatis_xml.mapper.UserMapper;
import com.robinzhu.mybatis_xml.utils.CommonUtils;
import com.robinzhu.mybatis_xml.utils.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhudapeng
 * 2019-09-08 22:00
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/createOrder")
    public Result createOrder(@Param("userId") String userId) {
        if (userId.equals(null) || userId.trim() == "") {
            return ResultUtil.error(1, "用户Id不能为空");
        } else {
            // 检查用户id
            User user = userMapper.getOne(userId);
            if (user == null) {
                return ResultUtil.error(2, "用户Id不存在");
            } else {
                Order order = new Order();
                order.setUserId(userId);
                String orderNo = CommonUtils.bornOrderNo();
                order.setOrderNumber(orderNo);
                orderMapper.createOrder(order);
                return ResultUtil.success();
            }
        }
    }

    @PostMapping(value = "/getUserByOrderNo")
    public Result getUserByOrderNo(@Param("orderNo") String orderNo) {
        Order order = orderMapper.queryOrderWithUserByOrderNo(orderNo);
        return ResultUtil.success(order);
    }

    @PostMapping(value = "/queryOrderAndDetail")
    public Result queryOrderAndDetail(@Param("orderNo") String orderNo) {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNo(orderNo);
        return ResultUtil.success(order);
    }
}
