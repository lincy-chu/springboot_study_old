package com.robinzhu.mybatis;

import com.robinzhu.mybatis.entity.User;
import com.robinzhu.mybatis.enums.StatusEnum;
import com.robinzhu.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-11 21:17
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setCode("002");
        user.setName("name002");
        user.setStatus(StatusEnum.ENABLE);

        // 新增
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User userUpd = userMapper.queryOne("5b3e7f78bca511e99860509a4c2c7107");
        userUpd.setName("新燕");
        userMapper.update(userUpd);
    }

    @Test
    public void testDelete() {
        userMapper.delete("5b3e7f78bca511e99860509a4c2c7107");
    }

    @Test
    public void testQueryOne() {
        User user = userMapper.queryOne("4d20a7c2bc3f11e99ecaa4991496b6cc");
        System.out.println(user);
    }

    @Test
    public void testParamSelect() {
        String code = "002";
        List<User> list = userMapper.queryByParams(code);
        log.info("查询编号为：{}，查询结果为：{}条，结果集为：{}", code, list.size(), Arrays.toString(list.toArray()));
    }
}
