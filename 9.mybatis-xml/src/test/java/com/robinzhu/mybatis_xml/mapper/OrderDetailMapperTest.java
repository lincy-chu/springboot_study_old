package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by zhudapeng
 * 2019-09-08 23:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailMapperTest {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Test
    public void insert() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("e36a99db3a1341ea8f7a947af027a69f");
        orderDetail.setTotalPrice(10000.00);
        orderDetail.setStatus(1);
        orderDetailMapper.insert(orderDetail);
    }

    @Test
    public void getOrderDetailById() {
        OrderDetail orderDetail = orderDetailMapper.getOrderDetailById("d0322d30d24b11e9a2827ab725937387");
        System.out.println(orderDetail);
    }
}