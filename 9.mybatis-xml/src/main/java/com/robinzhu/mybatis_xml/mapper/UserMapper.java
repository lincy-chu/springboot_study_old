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
     * @param pageIndex
     * @param pageSize
     * @return
     * 使用${}进行偏移量计算查询
     */
    List<User> getByPager(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 按照性别查询
     * @param sex
     * @return
     */
    List<User> getBySex(@Param("sex") Integer sex);

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    List<User> fuzzyQuery(@Param("keyword") String keyword);

    /**
     * 查询女性用户，如果输入了姓名，则按姓名查询
     * @param userName
     * @return
     * if的使用
     */
    List<User> queryUserList(@Param("userName") String userName);

    /**
     * 查找男性用户，如果输入姓名则按照姓名进行模糊查询，否则如果输入年龄则按照年龄查找，否则查询姓名为"大石头"的用户
     * @param name
     * @param age
     * @return
     * choose when otherwise的使用，相当于if else if else
     */
    List<User> queryUserByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 查找所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄按照年龄进行范围查询，如果两个都输入则两个条件都成立
     * @param name
     * @param age
     * @return
     * where和set的使用，都有一定的纠错功能
     */
    List<User> queryUserByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 按照多个id查询用户信息
     * @param ids
     * @return
     * foreach的使用
     */
    List<User> queryUserByIds(@Param("ids") String[] ids);
}
