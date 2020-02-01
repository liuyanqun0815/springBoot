package com.example.dynamicdatasource.enu;

import lombok.Data;


public enum DataSourceTypeEnum {
    PRIMARY("1"), USER("2");

    DataSourceTypeEnum(String code){
        this.code =code;
    }
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
