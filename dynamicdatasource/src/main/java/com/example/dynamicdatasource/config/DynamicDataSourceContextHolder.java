package com.example.dynamicdatasource.config;

import com.example.dynamicdatasource.enu.DataSourceTypeEnum;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/1/31
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceTypeEnum> context = new ThreadLocal<>();
    public static void setDataSourceType(DataSourceTypeEnum type){
        context.set(type);
    }
    public static DataSourceTypeEnum getDataSourceType(){
        return context.get();
    }
    public static void resetDataBaseType(){
        context.set(DataSourceTypeEnum.PRIMARY);
    }
}
