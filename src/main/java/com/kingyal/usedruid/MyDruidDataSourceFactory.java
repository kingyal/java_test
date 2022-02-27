package com.kingyal.usedruid;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * 连接池工厂
 */
public class MyDruidDataSourceFactory extends PooledDataSourceFactory{
    public MyDruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
