package com.robinzhu.mybatis_plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-09-01 17:37
 * 设置填充处理器
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
