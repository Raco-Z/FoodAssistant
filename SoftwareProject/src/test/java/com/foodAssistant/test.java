package com.foodAssistant;

import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.service.IAdminAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig.xml"})
public class test {

    @Autowired
    private IAdminAccountService as;

    @Test
    public void proxyTest()   {

        List<MenuNutrition> menus = as.getMenu();
        System.out.println(menus);

    }

    @Test
    public void createTest() {
        MenuNutrition menu = new MenuNutrition();
        menu.setFoodName("food5");
        menu.setFoodType("C");
        menu.setProtein(1);
        menu.setCalorie(1);
        menu.setFat(1);

        as.createMenu(menu);
    }

    @Test
    public void updateTest() {
        Menu menu = new Menu();
        menu.setFoodId(8);
        menu.setFoodName("food6");
        menu.setFoodType("A");

        as.updateMenu(menu);
    }
}
