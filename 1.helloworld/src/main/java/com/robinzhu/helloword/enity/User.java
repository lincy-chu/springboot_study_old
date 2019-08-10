package com.robinzhu.helloword.enity;

import lombok.*;

/**
 * Create by zhudapeng
 * 2019-08-09 21:12
 */
@Data
// @EqualsAndHashCode // 默认情况下，会使用所有非瞬态和非静态字段来生成equals和hascode方法，也可以指定具体使用那些属性
// @ToString // 生成toString方法，默认情况下，会输出类名、所有属性，属性会按照顺序输出，以逗号分隔
// @Builder // 可以进行Builder方式初始化
// @NoArgsConstructor // 无参构造器
// @RequiredArgsConstructor // 部分参数构造器
// @AllArgsConstructor // 全参构造器
public class User {
    private String id;
    private String userName;
    private String password;
}
