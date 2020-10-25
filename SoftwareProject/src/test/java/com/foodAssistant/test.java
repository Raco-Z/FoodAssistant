package com.foodAssistant;

import com.foodAssistant.proxy.AccountServiceProxy;
import com.foodAssistant.service.IAdminAccountService;
import com.foodAssistant.utils.ConnectionUtils;
import com.foodAssistant.utils.JdbcResourceUtils;
import com.foodAssistant.utils.TransactionManagerUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import org.junit.Test;

public class test {
    @Test
    public void proxyTest() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try{
            dataSource.setDriverClass(JdbcResourceUtils.getConfig("jdbc.driver").toString());
            dataSource.setJdbcUrl(JdbcResourceUtils.getConfig("jdbc.url").toString());
            dataSource.setUser(JdbcResourceUtils.getConfig("jdbc.username").toString());
            dataSource.setPassword(JdbcResourceUtils.getConfig("jdbc.password").toString());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        ConnectionUtils connectionUtils = new ConnectionUtils(dataSource);
        TransactionManagerUtils txManager = new TransactionManagerUtils(connectionUtils);
        AccountServiceProxy accountServiceProxy = new AccountServiceProxy(txManager);
        IAdminAccountService accountService = accountServiceProxy.getAccountService(IAdminAccountService.class);
        accountService.getMenu();
    }
}
