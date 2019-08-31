package com.robinzhu.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.entity.UserTwo;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import com.robinzhu.mybatis_plus.mapper.UserTwoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-09-01 00:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTwoTest {
    @Autowired
    private UserTwoMapper userMapper;

    @Test
    public void insertUserTwo() {
        UserTwo user = new UserTwo();
        user.setName("刘红雨");
        user.setAge(32);
        user.setEmail("lhy@baomidou.com");
        user.setManagerId("a5a48b43fe3d49c2fb3906e5ea1d5e04");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user); // 返回影响记录数
        log.info(String.valueOf(user));
        Assert.assertEquals(1, rows);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById("c3aed4d5b7cdd7b78c03f0cdb8149479"); // 返回影响行数
        System.out.println("影响行数: " + rows);
    }
}
