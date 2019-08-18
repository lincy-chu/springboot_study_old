package com.robinzhu.jpa.controller;

import com.robinzhu.jpa.dao.UserDao;
import com.robinzhu.jpa.entity.Result;
import com.robinzhu.jpa.entity.User;
import com.robinzhu.jpa.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhudapeng
 * 2019-08-18 21:00
 */
@RestController
@Slf4j
public class CustomUserController {
    @Autowired
    UserDao userDao;

    @PostMapping("/add")
    public Result addUser(User user) {
        log.info("新增用户:{}", user);
        userDao.save(user);
        return ResultUtil.success();
    }

    @PostMapping("/find/{id}")
    public Result findUser(@PathVariable String id) {
        log.info("查找用户id:{}", id);
        return ResultUtil.success(userDao.findById(id));
    }

    @PostMapping("/delete/{id}")
    public Result deleteUser(@PathVariable String id) {
        log.info("删除用户id:{}", id);
        userDao.deleteById(id);
        return ResultUtil.success();
    }

    @GetMapping("/find/{code}/{name}")
    public Result findUserByCodeAndName(@PathVariable("code") String code, @PathVariable("name") String name) {
        log.info("命名规则方式，查找用户：编码：{}，名称：{}", code, name);
        return ResultUtil.success(userDao.findByCodeAndName(code, name));
    }

    @GetMapping("/find/sql/{code}")
    public Result findUserByQuerySQL(@PathVariable("code") String code) {
        log.info("自定义sql方式，查找用户：编码：{}", code);
        return ResultUtil.success(userDao.queryByCode(code));
    }

    @GetMapping("/findByPage/{pageNum}/{pageSize}")
    public Result findByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return ResultUtil.success(userDao.findByCode("robinzhu", PageRequest.of(pageNum, pageSize)));
    }
}
