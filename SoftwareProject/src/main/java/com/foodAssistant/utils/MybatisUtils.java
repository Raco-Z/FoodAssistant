package com.foodAssistant.utils;

import com.foodAssistant.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 *Mybatis
 */
public class MybatisUtils {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    public void init() throws Exception{
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SqlSession对象
        sqlSession = factory.openSession();
        //获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    public void destroy() throws Exception{
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }
}
