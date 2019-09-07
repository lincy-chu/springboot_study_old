package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-09-07 22:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void getOne() {
        User user = userMapper.getOne("cd2ed7ded18b11e99a95f868216ab138");
        System.out.println(user);
    }

    @Test
    public void insert() throws ParseException {
        User user = new User();
        user.setUserName("王五");
        user.setPassword("12345678");
        user.setName("二狗子");
        user.setAge(18);
        user.setSex(1);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(date.parse("2019-09-02"));
        userMapper.insert(user);
    }

    @Test
    public void update() {
        User user = userMapper.getOne("c8bb50e0d19211e99a95f868216ab138");
        System.out.println(user);
        user.setUserName("朱朱朱");
        System.out.println(user);
        userMapper.update(user);
    }

    @Test
    public void delete() {
        userMapper.delete("cd2ed7ded18b11e99a95f868216ab138");
    }

    @Test
    public void login() {
        User user = userMapper.login("robin", "12345678");
        System.out.println(user);
    }

    @Test
    public void count() {
        Integer count = userMapper.userCount();
        System.out.println(count);
    }

    @Test
    public void getByPager() {
        Integer pageIndex = 1;
        Integer pageSize = 1;
        List<User> users = userMapper.getByPager(pageIndex * pageSize, 10);
        users.forEach(System.out::println);
    }
}
