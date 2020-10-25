package com.foodAssistant.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 与连接数据库有关的工具类
 * 目的：将线程和连接绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //加入连接的数据源信息
    private DataSource dataSource;

    public ConnectionUtils(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //获取连接
    public Connection getConnection(){
        try {
            Connection connection = threadLocal.get();
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //释放连接
    public void release(){
        threadLocal.remove();
    }
}
