package com.foodAssistant;

import com.foodAssistant.dao.IRecordDao;
import com.foodAssistant.domain.record.Record;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisRecordTest {
    private InputStream in;
    private IRecordDao recordDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
        recordDao = sqlSession.getMapper(IRecordDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //6.释放资源
        in.close();
    }

    @Test
    public void testSave(){
        Record record = new Record();
        record.setFoodName("aaa");
        record.setUserName("aaa");
        record.setFoodWeight(10);
        System.out.println("保存操作之前：");
        //5.执行保存方法
        recordDao.createRecord(record);

        System.out.println("保存操作之后：");
    }

    @Test
    public void  testSelect(){
        /*List<Record> records = recordDao.getRecord();
        for(Record record : records){
            System.out.println(record);
        }*/
        List<Record> records = recordDao.getRecordByUser("aaa");
        for(Record record : records){
            System.out.println(record);
        }
    }

    @Test
    public void testUpdate() {
        Record record = recordDao.getRecordById(2);
        record.setFoodWeight(10);
        recordDao.updateRecord(record);
        System.out.println(record);
    }
}
