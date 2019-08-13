package com.robinzhu.mybatis_xml.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ReaderDo {
    private String id;

    @NotNull(message = "readerName不能为空")
    @NotEmpty(message = "readerName不能为空")
    @Length(min = 8, max = 16, message = "readerName长度不少于${min}不超过${max}")
    private String readerName;

    @NotNull(message = "readerName不能为空")
    @NotEmpty(message = "readerName不能为空")
    @Length(min = 8, max = 16, message = "password长度不少于${min}不超过${max}")
    private String password;
}
