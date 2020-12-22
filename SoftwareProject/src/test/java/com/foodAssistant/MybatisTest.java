package com.foodAssistant;


import com.foodAssistant.dao.IUserDao;
import com.foodAssistant.domain.account.UserAccount;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //6.释放资源
        in.close();
    }

    @Test
    public void testSave(){
        UserAccount user = new UserAccount();
        user.setAccountName("user1");
        user.setAccountPassword("1234");
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.createUser(user);

        System.out.println("保存操作之后："+user);
    }

    @Test
    public void  testSelect(){
        List<UserAccount> users = userDao.findAll();
        for(UserAccount user :users)
        {
            System.out.println(user);
        }
    }

}
