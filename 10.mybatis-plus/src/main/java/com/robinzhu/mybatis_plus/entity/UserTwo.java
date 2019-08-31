package com.robinzhu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-08-31 22:04
 */
@Data
@TableName(value = "userTwo")
public class UserTwo {
    @TableId(type = IdType.UUID)
    private String id; // 主键

    @NotNull(message = "name不能为空")
    private String name; // 姓名

    @NotNull(message = "age不能为空")
    @Range(max = 120, min = 18, message = "age不能小于18不大于120")
    private Integer age; // 年龄

    @NotNull(message = "email不能为空")
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", message = "email格式不正确")
    private String email; // 邮箱

    @TableField(value = "manager_id")
    private String managerId; // 直属上司

    @NotNull(message = "createTime不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private LocalDateTime createTime; // 创建时间

    @NotNull(message = "updateTime不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private LocalDateTime updateTime; // 更新时间

    @NotNull(message = "version不能为空")
    private Integer version; // 版本

    @NotNull(message = "deleted不能为空")
    @TableLogic(value = "0", delval = "1") // 注解逻辑删除
    private Integer deleted; // 逻辑删除标识
}
