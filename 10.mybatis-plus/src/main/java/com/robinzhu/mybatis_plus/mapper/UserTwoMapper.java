package com.robinzhu.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.robinzhu.mybatis_plus.entity.UserTwo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-31 22:18
 */
@Component
@Mapper
public interface UserTwoMapper extends BaseMapper<UserTwo> {
    // 自定义查询
    @Select("select * from userTwo ${ew.customSqlSegment}")
    List<UserTwo> mySelectList(@Param(Constants.WRAPPER) Wrapper<UserTwo> wrapper);
}
