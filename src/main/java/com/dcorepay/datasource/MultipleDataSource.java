package com.dcorepay.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.remove();
    }


    public static void setDataSource(String dataSource){
        dataSourceKey.remove();
        dataSourceKey.set(dataSource);
    }
    public static String getKey(){
        return dataSourceKey.get();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

}