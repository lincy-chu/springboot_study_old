package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.Order;
import com.robinzhu.mybatis_xml.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by zhudapeng
 * 2019-09-08 20:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void queryOrderUserByOrderNo() {
        Order order = orderMapper.queryOrderWithUserByOrderNo("e36a99db3a1341ea8f7a947af027a69f");
        System.out.println(order);
    }

    @Test
    public void createOrder() {
        Order order = new Order();
        order.setUserId("1373dc54d21711e9a2827ab725937387");
        String orderNumber = CommonUtils.bornOrderNo();
        order.setOrderNumber(orderNumber);
        orderMapper.createOrder(order);
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNo() {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNo("e36a99db3a1341ea8f7a947af027a69f");
        System.out.println(order);
    }
}