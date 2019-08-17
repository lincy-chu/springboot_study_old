package com.robinzhu.upload.controller;

import com.robinzhu.upload.entity.CommonException;
import com.robinzhu.upload.entity.Result;
import com.robinzhu.upload.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhudapeng
 * 2019-08-17 10:04
 */
@RestController
@Slf4j
public class FileUploadController {
    @PostMapping("/j2eeUpload")
    @CrossOrigin // 设置允许跨域请求
    public Result j2eeUpload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            throw new CommonException(1, "上传文件不能为空", null);
        }
        // 文件类型
        String contentType = file.getContentType();
        // SpringMVC处理后的文件名
        String fileName = file.getName();
        log.info("服务器文件名："+ fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();
        /**
         * 保存文件
         *  这里使用二进制直接保存
         *  这里直接使用transferTo
         */
        String filePath = "/Users/zhudapeng/Documents/uploadFile/" + origFileName;
        file.transferTo(new File(filePath));
        Map<String, Object> map = new HashMap<>();
        map.put("filePath", filePath);
        log.info("长传成功后的路径：" + filePath);
        return ResultUtil.success(map);
    }

    @PostMapping("/fileUpload") // fileUpload形式上传
    @CrossOrigin // 设置允许跨域请求
    public Result fileUpload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            throw new CommonException(1, "上传文件不能为空", null);
        }
        // 文件类型
        String contentType = file.getContentType();
        // SpringMVC处理后的文件名
        String fileName = file.getName();
        log.info("服务器文件名："+ fileName);
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();
        /**
         * 保存文件
         *  这里使用二进制直接保存
         *  这里直接使用transferTo
         */
        String filePath = "/Users/zhudapeng/Documents/uploadFile/" + origFileName;
        file.transferTo(new File(filePath));
        Map<String, Object> map = new HashMap<>();
        map.put("filePath", filePath);
        log.info("长传成功后的路径：" + filePath);
        return ResultUtil.success(map);
    }
}
