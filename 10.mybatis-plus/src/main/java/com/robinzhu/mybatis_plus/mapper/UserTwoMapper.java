package com.robinzhu.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robinzhu.mybatis_plus.entity.UserTwo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Create by zhudapeng
 * 2019-08-31 22:18
 */
@Component
@Mapper
public interface UserTwoMapper extends BaseMapper<UserTwo> {
}
