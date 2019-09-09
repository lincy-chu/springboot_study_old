package com.robinzhu.mybatis_xml.mapper;

import com.robinzhu.mybatis_xml.entity.User;
import com.robinzhu.mybatis_xml.enums.SexEnum;
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
        user.setUserName("王石头");
        user.setPassword("12345678");
        user.setName("石头");
        user.setAge(60);
        SexEnum sex = SexEnum.Female;
        user.setSex(sex.getIndex());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(date.parse("1988-08-08"));
        userMapper.insert(user);

        User user1 = new User();
        user1.setUserName("章泽天");
        user1.setPassword("12345678");
        user1.setName("奶茶");
        user1.setAge(10);
        SexEnum sex1 = SexEnum.Female;
        user1.setSex(sex1.getIndex());
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        user1.setBirthday(date1.parse("2009-06-08"));
        userMapper.insert(user1);

        User user2 = new User();
        user2.setUserName("李世民");
        user2.setPassword("12345678");
        user2.setName("小军");
        user2.setAge(18);
        SexEnum sex2 = SexEnum.Female;
        user2.setSex(sex2.getIndex());
        SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd");
        user2.setBirthday(date2.parse("1981-08-08"));
        userMapper.insert(user2);
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

    @Test
    public void getBySex() {
        SexEnum sex = SexEnum.Female;
        List<User> users = userMapper.getBySex(sex.getIndex());
        users.forEach(System.out::println);
    }

    @Test
    public void fuzzyQuery() {
        String keyword = "1";
        List<User> users = userMapper.fuzzyQuery(keyword);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserList() {
        List<User> users = userMapper.queryUserList("章泽天");
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByNameOrAge() {
        List<User> users = this.userMapper.queryUserByNameOrAge(null, 12);
        users.forEach(System.out::println);
    }


    @Test
    public void queryUserByNameAndAge() {
        List<User> users = userMapper.queryUserByNameAndAge("二狗子", 16);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByIds() {
        List<User> users = userMapper.queryUserByIds(new String[]{"137a698ed21711e9a2827ab725937387", "7341b0b8d21511e9a2827ab725937387"});
        users.forEach(System.out::println);
    }

    @Test
    public void testSession() {
        // 测试一级缓存
        System.out.println(this.userMapper.fuzzyQuery("二狗子1"));
        System.out.println(this.userMapper.fuzzyQuery("二狗子1"));
    }

    @Test
    public void testSecondSession() {
        // 测试二级缓存
        System.out.println(this.userMapper.fuzzyQuery("章泽天"));
    }

    @Test
    public void queryUserByDateRange() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<User> users = userMapper.queryUserByDateRange(dateFormat.parse("2002-08-08 00:00:00"), dateFormat.parse("2018-10-08 23:59:59"));
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByBirthdayInRange() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<User> users = userMapper.queryUserByBirthdayInRange(dateFormat.parse("2002-08-08 00:00:00"), dateFormat.parse("2018-10-08 23:59:59"));
        users.forEach(System.out::println);
    }
}
