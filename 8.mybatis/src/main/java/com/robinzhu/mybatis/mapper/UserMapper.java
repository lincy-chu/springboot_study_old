package com.robinzhu.mybatis.mapper;

import com.robinzhu.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-11 16:17
 * 注解配置
 * 方式1：注释方式
 */
@Component
public interface UserMapper {
    // 配置返回的字段

    /**
     * @Select 是查询类的注释，所有的查询均使用
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    /**
     * @Result 修饰符返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和属性库属性名保持一致，就不需要这个属性来修饰
     */
    @Results({
        @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.DATE),
        @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.DATE)
    })
    User queryOne(String id);

    // 枚举类 默认是使用 EnumTypeHandler 处理类，即使用枚举name作为值
    //status 为枚举类 也可以直接指定了 typeHandler类 作为处理类 ，如：#{status,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler}
    //还可以在sqlFactory 直接使用  TypeHandlerRegistry  进行注册 详看；MybatisConfig 类
    //最简单：自定义 ConfigurationCustomizer 了进行设置 详看；MybatisConfig 类

    /**
     * @Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
     * @param user
     * @return
     */
    @SelectKey(keyColumn = "id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')", keyProperty = "id") // 使用生成的uuid作为主键
    @Insert(value = "insert into user(id, code, name, status) values (#{id, jdbcType=VARCHAR}, #{code}, #{name}, #{status})")
    /**
     * @Options 映射语句的属性，如新增时需要返回自增的id
     * @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
     */
    int insert(User user);

    /**
     * @Update 负责修改，也可以直接传入对象
     * @param user
     */
    @Update("update user set code = #{code}, name = #{name}, status = #{status} where id = #{id}")
    void update(User user);

    /**
     * @Delete 负责删除
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(String id);

    @Select("select * from user where code = #{code}")
    @Results({
        @Result(column = "gmt_create", property = "gmtCreate", jdbcType = JdbcType.DATE),
        @Result(column = "gmt_modified", property = "gmtModified", jdbcType = JdbcType.DATE)
    })
    List<User> queryByParams(@Param("code") String code);
}
