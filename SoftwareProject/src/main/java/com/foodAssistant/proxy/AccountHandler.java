package com.foodAssistant.proxy;

import com.foodAssistant.service.IAdminAccountService;
import com.foodAssistant.service.IUserAccountService;
import com.foodAssistant.service.impl.AdminAccountServiceImpl;
import com.foodAssistant.service.impl.UserAccountServiceImpl;
import com.foodAssistant.utils.TransactionManagerUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 事务控制代理的代理方式
 */
public class AccountHandler implements InvocationHandler {

    private final TransactionManagerUtils txManager;

    private AdminAccountServiceImpl adminAccountService = new AdminAccountServiceImpl();
    private UserAccountServiceImpl userAccountService = new UserAccountServiceImpl();

    public AccountHandler(TransactionManagerUtils txManager){
        this.txManager = txManager;

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = null;
        try {
            //创建事务，取消自动提交
            txManager.begin();
            //执行方法
            returnValue = method.invoke(adminAccountService,args);
            //成功执行，提交事务
            txManager.commit();
            return returnValue;
        } catch (Exception e) {
            //出现异常，回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //释放资源
            txManager.release();
        }
    }
}
