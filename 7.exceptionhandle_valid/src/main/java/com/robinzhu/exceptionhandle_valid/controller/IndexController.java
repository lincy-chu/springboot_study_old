package com.robinzhu.exceptionhandle_valid.controller;

import com.robinzhu.exceptionhandle_valid.entity.CommonException;
import com.robinzhu.exceptionhandle_valid.entity.Result;
import com.robinzhu.exceptionhandle_valid.entity.User;
import com.robinzhu.exceptionhandle_valid.utils.ResultUtil;
import com.robinzhu.exceptionhandle_valid.utils.ValidatorUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validator;

/**
 * Create by zhudapeng
 * 2019-08-11 10:34
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public String demo() {
        throw new CommonException(1001, "发送异常", null);
    }

    @GetMapping("/valid")
    public Result valid(@Valid User user) {
        return ResultUtil.success(user);
    }

    @PostMapping("/valid/manual")
    public Result manual(User user) {
        // 手动校验
        ValidatorUtil.validate(user);
        return ResultUtil.success(user);
    }
}
