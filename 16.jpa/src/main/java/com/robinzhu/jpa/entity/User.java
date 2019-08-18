package com.robinzhu.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Create by zhudapeng
 * 2019-08-18 20:34
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "custom_user")
public class User implements Serializable {
    private static final long serialVersionUID = -3752294262021766827L;

    /**
     * 唯一标识
     */
    @Id
    @GenericGenerator(name = "jpa-uuid",strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
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
     * 创建时间
     */
    @CreatedDate // 表示该字段为创建时间字段，在这个实体被insert的时候，会设置值。需要先在类上注解@EntityListeners(AuditingEntityListener.class)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @LastModifiedDate // 有修改时自动更新时间，需要先在类上注解@EntityListeners(AuditingEntityListener.class)
    private Date gmtModified;

}
