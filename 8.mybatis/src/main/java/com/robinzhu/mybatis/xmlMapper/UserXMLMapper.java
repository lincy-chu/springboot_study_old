package com.robinzhu.mybatis.xmlMapper;

import com.robinzhu.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-11 22:38
 * 方式2：xml方式
 * 没什么区别，就是sql语句放入到xml中进行编写而已
 */
@Component
public interface UserXMLMapper {
    User queryOne(String id);
    int insert(User user);
    void update(User user);
    void delete(String id);
    List<User> queryByParams(@Param("code") String code);
}
