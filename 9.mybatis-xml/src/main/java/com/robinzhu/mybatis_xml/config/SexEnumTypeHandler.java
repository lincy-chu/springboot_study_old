package com.robinzhu.mybatis_xml.config;

import com.robinzhu.mybatis_xml.enums.SexEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

/**
 * Create by zhudapeng
 * 2019-09-08 11:09
 * 枚举索引处理类
 */

@MappedTypes(value = {SexEnum.class})
public class SexEnumTypeHandler<E extends Enum<E>> extends EnumOrdinalTypeHandler {
    public SexEnumTypeHandler(Class<E> type) {
        super(type);
    }
}
