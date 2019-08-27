package com.robinzhu.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Create by zhudapeng
 * 2019-08-27 20:29
 * 学生实体类
 */
@Data
@AllArgsConstructor // 注解在类上，为类提供一个全参的构造方法
@NoArgsConstructor  // 注解在类上，为类提供一个无参的构造方法
@Entity
/**
 * @Table(name = "", catalog = "", schema = "")
 * 与@Entity配合使用，只能标注在实体的class定义处，表示实体对应数据库表的信息
 * name：可选，映射表的名称，默认表名和实体名称一致，只有在不一致的情况下才需要指定表名
 *
 * @Embeddable 表示一个非Entity类可以嵌入到另一个Entity类中作为属性而存在
 *
 * Hibernate属性级别注解
 * 添加方式：
 *  1.写在属性字段上面
 *  2.写在属性的get访问器的上面
 *
 * @Id: 必须，定义了映射到数据库表的主键的属性，一个实体类可以有一个或多个属性被映射为主键，可置于主键属性或者getXxx()前
 * @SequenceGenerator
 * @GeneratedValue(strategy=GenerationType, generator="")
 *      可选，用于定义主键生成策略
 *      strategy表示主键生成策略，取值有：
 *          1.GenerationType.AUTO：根据底层数据库自动选择（默认）
 *          2.GenerationType.IDENTITY：根据数据层的Identity字段生成（唯一）
 *          3.GenerationType.SEQUENCE：使用Sequence来决定主键的取值
 * @Column
 * @Embedded
 * @EmbeddedId
 * @Transient
 *
 */
public class Student {
    @Id
     @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    // @GenericGenerator(name = "jpa-uuid", strategy = "assigned") // 手工赋值的策略
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String sid; // 学号

//    @Id // 多主键需要实现Serializable，当为主键时，String型的需要限制其长度
//    @Column(length = 32)
    private String sName; // 姓名
    private String gender; // 性别
    private LocalDateTime birthday; // 生日
    private String major; // 专业
//    private String address; // 地址
    private Address address;
}
