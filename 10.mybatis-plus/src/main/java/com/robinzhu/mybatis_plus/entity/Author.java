package com.robinzhu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-08-07 22:59
 */
@Data
public class Author {
    /**
     * 主键
     * 如果想要使用id自增的，就需要把mybatis-plus这个id生成的功能给关掉
     * 添加注释
     *  在id字段上加上注释即可
     *  @TableId(value = "id", type = IdType.AUTO)
     *  其他type类型介绍
     *  AUTO: AUTO(0, "数据库ID自增")
     *  INPUT: INPUT(1, "用户输入ID")
     *  ID_WORKER: ID_WORKER(2, "全局唯一ID")
     *  UUID: UUID(3, "全局唯一ID")
     *  NONE: NONE(4, "该类型为未设置主键类型")
     *  ID_WORKER_STR: ID_WORKER_STR(5, "字符串全局唯一ID")
     */

    @TableId(type = IdType.UUID)
    private String id;
    // 姓名
    @NotNull(message = "name字段不能为空")
    private String name;
    // 年龄
    private Integer age;
    // 邮箱
    @NotBlank(message = "email不能为空")
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", message = "邮箱格式不正确")
    private String email;

    private String managerId;

    @NotNull(message = "createTime字段不能为空")
    private LocalDateTime createTime;
}
