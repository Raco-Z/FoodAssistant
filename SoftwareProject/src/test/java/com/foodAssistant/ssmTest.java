package com.foodAssistant;

import com.foodAssistant.dao.IUserDao;
import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.domain.record.Record;
import com.foodAssistant.service.IUserAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig.xml"})
public class ssmTest {
    @Autowired
    private IUserAccountService userAccountService;
    @Test
    public void springMybatis(){
        List<UserAccount> users = userAccountService.findAll();
        for(UserAccount user : users){
            System.out.println(user);
        }
    }

    @Test
    public void recordTest(){
        List<Record> records = userAccountService.getRecord();
        for(Record record : records){
            System.out.println(record);
        }
    }

    @Test
    public void menuTest() {
        List<MenuNutrition> menus = userAccountService.getMenu();
        for(MenuNutrition menu : menus){
            System.out.println(menu);
        }
    }
}
