package com.robinzhu.mybatis_xml.controller;

import com.robinzhu.mybatis_xml.entity.ReaderDo;
import com.robinzhu.mybatis_xml.entity.Result;
import com.robinzhu.mybatis_xml.service.ReaderService;
import com.robinzhu.mybatis_xml.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/reader")
public class ReaderController {
    @Autowired
    private ReaderService service;

    @GetMapping(value = "/findAll")
    public Result findAll() {
        return ResultUtil.success(service.findAll());
    }

    @GetMapping(value = "/insert")
    public Result insert(@Valid ReaderDo readerDo) {
        service.insert(readerDo);
        return ResultUtil.success();
    }
}
