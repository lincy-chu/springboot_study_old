package com.robinzhu.mybatis_xml.enums;

/**
 * Create by zhudapeng
 * 2019-09-08 11:06
 */
public enum SexEnum {
    Female(0, "女"), Male(1, "男");
    private Integer index;
    private String sexDesc;

    SexEnum(int index, String sexDesc) {
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }

    public String getSexDesc() {
        return this.sexDesc;
    }
}
