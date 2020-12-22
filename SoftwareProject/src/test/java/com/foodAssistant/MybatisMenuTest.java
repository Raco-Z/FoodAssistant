package com.foodAssistant;


import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.MenuNutrition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisMenuTest {
    private InputStream in;
    private IMenuDao menuDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
        menuDao = sqlSession.getMapper(IMenuDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //6.释放资源
        in.close();
    }

    @Test
    public void testSave(){
        MenuNutrition menu = new MenuNutrition();
        menu.setFoodName("aaa");
        menu.setFoodType("t");
        menu.setCalorie(1.0);
        menu.setProtein(1.0);
        menu.setCarbohydrate(1.0);
        menu.setFat(1.0);
        //5.执行保存方法
        menuDao.createMenu(menu);

    }

    @Test
    public void  testSelect(){
        List<MenuNutrition> menus = menuDao.getMenu();
        for(MenuNutrition menu :menus)
        {
            System.out.println(menu);
        }
    }

}
