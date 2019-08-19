package com.robinzhu.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Create by zhudapeng
 * 2019-08-13 21:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthorTest {
    @Autowired
    private AuthorMapper userMapper;

    @Test
    public void insert() {
        Author user = new Author();
        user.setName("向3D");
        user.setAge(89);
        user.setEmail("xs@baomidou.com");
        user.setManagerId("c62d6a6488f9d60b60d7e48eeb80c704");
        user.setCreateTime(LocalDateTime.now());
        user.setRemark("向三维的备注");
        int rows = userMapper.insert(user); // 返回影响记录数
        log.info(String.valueOf(user));
        Assert.assertEquals(1, rows);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void selectByIdTest() {
        Author author = userMapper.selectById("132db284bdd2b6907624cfb9d82998c2");
        System.out.println(author);
    }

    @Test
    public void selectByIds() {
        List<String> list = Arrays.asList("6783fcbae1ec503a5e93d9725789ef5c", "c62d6a6488f9d60b60d7e48eeb80c704", "02f4545f737ff0ab58c9cbf8e7f5d843");
        List<Author> authors = userMapper.selectBatchIds(list); // selectBatchIds接收id数组
        authors.forEach(System.out::println);
    }

    @Test
    public void selectByMap() { // 通过map形成多条件并列查找
        /**
         * map.put("name", "刘红雨")
         * map.put("age", 30)
         * = where name = "刘红雨" and age = 30
         */
        Map<String, Object> map = new HashMap<>();
        // map.put("author_name", "王天风");
        // map.put("age", 32); // 第一个参数是数据表中对应的列名（而不是实体类中的字段名）
        map.put("manager_id", "c62d6a6488f9d60b60d7e48eeb80c704");
        List<Author> author = userMapper.selectByMap(map);
        author.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper() { // 通过条件构造器查找
        /**
         * 1.名字中包含雨并且年龄小于40
         * name like '%雨%' and age < 40
         */
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>(); // 创建条件构造器，方式1
        // QueryWrapper<Author> queryWrapper1 = Wrappers.query(); // 创建条件构造器，方式2
        queryWrapper.like("author_name", "雨").lt("age", 40); // column均为数据表中的列名
        List<Author> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper1() { // 通过自定义的条件构造器进行查找
        /**
         * 2.名字中包含雨并且年龄大于等于20且小于40并且email不为空
         * name like "%雨%" and age between 20 and 40 and email is not null
         */
        QueryWrapper<Author> query = Wrappers.query();
        query.like("author_name", "雨").between("age", 20, 40).isNotNull("email");
        List<Author> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper2() {
        /**
         * 3.名字为王姓或者年龄大于等于25，按年龄降序排列，年龄相同按照id剩余排列
         * name like '王%' or age >= 25 order by age desc, id asc
         */
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("author_name", "王") // likeRight表示只有右侧有通配符%
                .or() // 等价于或者
                .ge("age", 25) // ge大于等于
                .orderByDesc("age").orderByAsc("author_id");
        List<Author> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
