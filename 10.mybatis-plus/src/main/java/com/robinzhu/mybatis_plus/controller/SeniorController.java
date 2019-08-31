package com.robinzhu.mybatis_plus.controller;

import com.robinzhu.mybatis_plus.entity.Result;
import com.robinzhu.mybatis_plus.entity.UserTwo;
import com.robinzhu.mybatis_plus.mapper.UserTwoMapper;
import com.robinzhu.mybatis_plus.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Create by zhudapeng
 * 2019-08-31 22:34
 */
@RestController
@RequestMapping(value = "/senior")
public class SeniorController {
    @Autowired
    UserTwoMapper user2Mapper;

    @PostMapping(value = "/insert")
    public Result insert(@Valid UserTwo user2) {
        user2Mapper.insert(user2);
        return ResultUtil.success();
    }
}
