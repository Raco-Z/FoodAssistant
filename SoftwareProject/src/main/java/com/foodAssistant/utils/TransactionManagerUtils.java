package com.foodAssistant.utils;

/**
 * 与实务管理相关的工具类
 */
public class TransactionManagerUtils {

    private ConnectionUtils connectionUtils;

    public TransactionManagerUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

    public void setConnectionUtils(){
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void begin(){
        try{
            connectionUtils.getConnection().setAutoCommit(false);
            System.out.println("begin");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //提交事务
    public void commit(){
        try{
            connectionUtils.getConnection().commit();
            System.out.println("commit");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //回滚事务
    public void rollback(){
        try{
            connectionUtils.getConnection().rollback();
            System.out.println("rollback");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    //释放资源
    public void release(){
        try{
            connectionUtils.getConnection().close();
            connectionUtils.release();
            System.out.println("close");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
