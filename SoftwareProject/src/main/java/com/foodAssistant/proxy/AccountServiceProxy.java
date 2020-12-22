package com.foodAssistant.proxy;

import com.foodAssistant.utils.TransactionManagerUtils;

import java.lang.reflect.Proxy;

/**
 * 创建代理对象
 */
//已交给Spring
public class AccountServiceProxy {

    private TransactionManagerUtils txManager;

    public AccountServiceProxy(TransactionManagerUtils txManager){

        this.txManager = txManager;
    }

    //创建一个用户或者管理员的代理对象
    public <T> T getAccountService(Class<T> serviceInterfaceClass)  {
        System.out.println("创建代理对象"+serviceInterfaceClass);
        return (T)Proxy.newProxyInstance(serviceInterfaceClass.getClassLoader(),new Class[]{serviceInterfaceClass},new AccountHandler(txManager));
    }

}
