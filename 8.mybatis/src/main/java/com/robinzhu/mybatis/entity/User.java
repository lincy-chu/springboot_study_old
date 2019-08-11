package com.robinzhu.mybatis.entity;

import com.robinzhu.mybatis.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Create by zhudapeng
 * 2019-08-11 11:35
 */

/**
 * 数据校验
 *    在web开发时，对于请求参数，一般上需要进行参数合法性校验，原先的写法时一个个字段一个区判断，这种方式不太通用了，所以Java的JSR303：Bean Validation规范就是解决这个问题的。
 *    JSR 303指示一个规范，并无具体实现，目前通常通常都是hibernate-validator进行统一参数校验
 *
 *    JSR303定义的校验类型
 *
 *    Constraint                    详细信息
 *    @Null                         被注释的元素必须为null
 *    @NotNull                      被注释的元素必须不为null
 *    @AssertTrue                   被注释的元素必须为true
 *    @AssertFalse                  被注释的元素必须为false
 *    @min(value)                   被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *    @Max(value)                   被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 *    @DecimalMin(value)            被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *    @DecimalMax(value)            被注释的元素必须是一个数字，其值不许小于等于指定的最大值
 *    @Size(max, min)               被注释的元素大小必须在指定的范围内
 *    @Digits(integer, fraction)    被注释的元素必须是一个数字，其值必须在可接受的范围内
 *    @Post                         被注释的元素必须是一个过去的日期
 *    @Future                       被注释的元素必须是一个将来的日期
 *    @Pattern(value)               被注释的元素必须符合指定的正则表达式
 *
 *    Hibernate Validator附加的constraint
 *    Constraint                    详细信息
 *    @Email                        被注释的元素必须是电子邮箱地址
 *    @Length                       被注释的字符串的大小必须在指定的范围内
 *    @NotEmpty                     被注释的字符串的必须为非空
 *    @Range                        被注释的元素在合适的范围内
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 唯一标识
     */
    private String id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     * 1 启用
     * 2 停用
     */
    private StatusEnum status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;
}
