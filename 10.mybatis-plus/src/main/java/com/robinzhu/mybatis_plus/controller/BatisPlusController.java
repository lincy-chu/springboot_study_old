package com.robinzhu.mybatis_plus.controller;

import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.entity.Result;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import com.robinzhu.mybatis_plus.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Create by zhudapeng
 * 2019-08-13 23:26
 */
@RestController
@RequestMapping("/batisPlus")
public class BatisPlusController {
    @Autowired
    AuthorMapper authorMapper;

    @PostMapping("/insert")
    public Result insert(@Valid Author author) {
        authorMapper.insert(author);
        return ResultUtil.success();
    }

    @GetMapping("/list")
    public Result list() {
        List<Author> authors = authorMapper.selectList(null);
        return ResultUtil.success(authors);
    }
}
