package com.robinzhu.jpa.dao;

import com.robinzhu.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Create by zhudapeng
 * 2019-08-18 20:49
 */
public interface UserDao extends PagingAndSortingRepository<User, String> { // 这里继承了PagingAndSortingRepository，其本身实现了分页功能，还可以按需继承CrudRepository或者JpaRepository等。占位符: ?+表示具体的参数索引值
    Optional<User> findById(String id);

    // 使用自动命名规则进行查询服务
    List<User> findByCodeAndName(String code, String name);

    // 使用@Query进行自定义sql编写，nativeQuery=true表示正常sql语法，否则是hsql语法
    @Query(value = "select * from custom_user where code = ?1", nativeQuery = true)
    List<User> queryByCode(String code);

    // 分页
    Page<User> findByCode(String code, Pageable pageable);
}
