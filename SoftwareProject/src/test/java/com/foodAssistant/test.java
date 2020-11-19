package com.foodAssistant;

import com.foodAssistant.proxy.AccountServiceProxy;
import com.foodAssistant.service.IAccountService;
import com.foodAssistant.service.IAdminAccountService;
import com.foodAssistant.utils.ConnectionUtils;
import com.foodAssistant.utils.JdbcResourceUtils;
import com.foodAssistant.utils.TransactionManagerUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import org.junit.Test;

import javax.sql.DataSource;

public class test {
    @Test
    public void proxyTest()   {

        DataSource dataSource = new ComboPooledDataSource();
        ConnectionUtils connectionUtils = new ConnectionUtils();
        TransactionManagerUtils txManager = new TransactionManagerUtils();
        AccountServiceProxy accountServiceProxy = new AccountServiceProxy(txManager);
        IAdminAccountService accountService = accountServiceProxy.getAccountService(IAdminAccountService.class);
        System.out.println(accountService.getMenu());

    }
}
