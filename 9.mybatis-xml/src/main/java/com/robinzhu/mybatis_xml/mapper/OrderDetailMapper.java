package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Create by zhudapeng
 * 2019-09-08 23:00
 */
@Mapper
@Component
public interface OrderDetailMapper {
    /**
     * 新建订单详情
     * @param orderDetail
     */
    void insert(OrderDetail orderDetail);

    /**
     * 通过id获取订单详情
     * @param id
     * @return
     */
    OrderDetail getOrderDetailById(@Param("id") String id);
}
