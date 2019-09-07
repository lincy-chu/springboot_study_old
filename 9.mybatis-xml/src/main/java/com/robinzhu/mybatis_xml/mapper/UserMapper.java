package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    List<User> findAll();
    User getOne(String id);
    Integer insert(User user);
    void update(User user);
    void delete(String id);

    /**
     * 登录（直接使用注释指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询用户数
     * @return
     */
    Integer userCount();

    /**
     * 分页查询
     * @param offset
     * @param pageSize
     * @return
     */
    List<User> getByPager(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
