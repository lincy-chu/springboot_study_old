package com.robinzhu.mybatis_plus;

import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        user.setName("新燕");
        user.setAge(36);
        user.setEmail("1365076679@126.com");
        int rows = userMapper.insert(user); // 返回影响记录数
        log.info(String.valueOf(user));
        Assert.assertEquals(1, rows);
        System.out.println("影响记录数：" + rows);
    }
}
