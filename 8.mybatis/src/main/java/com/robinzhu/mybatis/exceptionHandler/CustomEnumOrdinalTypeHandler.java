package com.robinzhu.mybatis.exceptionHandler;

import com.robinzhu.mybatis.enums.StatusEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

/**
 * Create by zhudapeng
 * 2019-08-11 21:13
 * 枚举处理类
 */
@MappedTypes(value = {StatusEnum.class})
public class CustomEnumOrdinalTypeHandler<E extends Enum<E>> extends EnumOrdinalTypeHandler<E> {
    public CustomEnumOrdinalTypeHandler(Class<E> type) {
        super(type);
    }
}
