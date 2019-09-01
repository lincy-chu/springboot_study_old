package com.robinzhu.mybatis_plus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.robinzhu.mybatis_plus.entity.UserTwo;
import com.robinzhu.mybatis_plus.mapper.UserTwoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

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
        // 逻辑删除
        int rows = userMapper.deleteById("c3aed4d5b7cdd7b78c03f0cdb8149479"); // 返回影响行数
        System.out.println("影响行数: " + rows);
    }

    @Test
    public void select() {
        List<UserTwo> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void updateById() {
        UserTwo userTwo = new UserTwo();
        userTwo.setAge(27);
        userTwo.setId("a5a48b43fe3d49c2fb3906e5ea1d5e04");
        int rows = userMapper.updateById(userTwo);
        System.out.println("影响行数: " + rows);
    }

    @Test
    public void mySelect() {
        List<UserTwo> list = userMapper.mySelectList(Wrappers.<UserTwo>lambdaQuery().gt(UserTwo::getAge, 25).eq(UserTwo::getDeleted, 0)); // 自定义的需要单独自定义查询来剔除逻辑删除的数据
        list.forEach(System.out::println);
    }

    @Test
    public void autoAddCreateTime() {
        UserTwo user = new UserTwo();
        user.setName("刘明超");
        user.setAge(31);
        user.setEmail("lmc@baomidou.com");
        int rows = userMapper.insert(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void autoAddUpdateTime() {
        UserTwo user = new UserTwo();
        user.setManagerId("a5a48b43fe3d49c2fb3906e5ea1d5e04");
        user.setId("17ab75732f0842b697cd1612dc8b00c2");
        int rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }
}
