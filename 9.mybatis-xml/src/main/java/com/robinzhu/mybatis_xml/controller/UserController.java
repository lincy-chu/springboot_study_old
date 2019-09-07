package com.robinzhu.mybatis_xml.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.robinzhu.mybatis_xml.entity.User;
import com.robinzhu.mybatis_xml.entity.Result;
import com.robinzhu.mybatis_xml.mapper.UserMapper;
import com.robinzhu.mybatis_xml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/findAll")
    public Result findAll() {
        return ResultUtil.success(userMapper.findAll());
    }

    @PostMapping(value = "/insert")
    public Result insert(@Valid User user) {
        userMapper.insert(user);
        return ResultUtil.success();
    }

    @GetMapping(value = "/getByPager/{pageIndex}/{pageSize}")
    public Result getByPager(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize) {
        Integer total = userMapper.userCount();
        List<User> users = userMapper.getByPager((pageIndex - 1) * pageSize, pageSize);
        JSONObject data = new JSONObject();
        data.put("list", users);
        data.put("total", total);
        return ResultUtil.success(data);
    }
}
