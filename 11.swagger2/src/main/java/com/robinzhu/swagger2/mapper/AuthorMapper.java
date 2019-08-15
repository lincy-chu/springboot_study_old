package com.robinzhu.swagger2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robinzhu.swagger2.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Create by zhudapeng
 * 2019-08-07 23:32
 */
@Component
@Mapper
public interface AuthorMapper extends BaseMapper<Author> {
}
