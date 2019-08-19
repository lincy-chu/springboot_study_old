package com.robinzhu.mybatis_plus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mysql.cj.QueryResult;
import com.robinzhu.mybatis_plus.entity.Author;
import com.robinzhu.mybatis_plus.entity.Result;
import com.robinzhu.mybatis_plus.mapper.AuthorMapper;
import com.robinzhu.mybatis_plus.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @GetMapping("/getByName")
    public Result getByName() {
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Author::getName, "robinzhu");
        List<Author> authors = authorMapper.selectList(queryWrapper);
        return ResultUtil.success(authors);
    }

    @GetMapping("/getMoreParams")
    public Result getMoreParams() {
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .and(obj -> obj.lt(Author::getAge, 19))
                .like(Author::getName, "元璋");
        List<Author> authors = authorMapper.selectList(queryWrapper);
        return ResultUtil.success(authors);
    }
}
