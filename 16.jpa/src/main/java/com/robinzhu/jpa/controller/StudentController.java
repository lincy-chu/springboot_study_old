package com.robinzhu.jpa.controller;

import com.robinzhu.jpa.dao.StudentsDao;
import com.robinzhu.jpa.entity.Address;
import com.robinzhu.jpa.entity.Result;
import com.robinzhu.jpa.entity.Student;
import com.robinzhu.jpa.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-08-27 21:02
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentsDao studentsDao;

    @GetMapping("insert")
    public Result insert() {
        Student student = new Student();
        student.setSName("朱大鹏");
        student.setGender("男");
        student.setBirthday(LocalDateTime.now());
        student.setMajor("通信工程");
        student.setAddress(new Address("568900", "河南新县", "18819318565"));
        studentsDao.save(student);
        return ResultUtil.success();
    }
}
