package com.foodAssistant.controller;



import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.factory.BeanFactory;
import com.foodAssistant.service.IAdminAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<MenuNutrition> getMenu() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<MenuNutrition> rtn = adminAccountService.getMenu();
        return rtn;
    }

    @RequestMapping(value = "/getMenuById",method = RequestMethod.GET)
    public Menu getMenuById(Integer foodId){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuById(foodId);
        return menu;
    }

    @RequestMapping(value = "/getMenuByName",method = RequestMethod.GET)
    public Menu getMenuByName(String foodName){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuByName(foodName);
        return menu;
    }

    @RequestMapping(value = "/getMenuByType",method = RequestMethod.GET)
    public List<MenuNutrition> getMenuByType(String foodType){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<MenuNutrition> menus = adminAccountService.getMenuByType(foodType);
        return menus;
    }

    @RequestMapping(value = "/createMenu",method = RequestMethod.POST)
    public void createMenu(@RequestBody MenuNutrition menuNutrition){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        adminAccountService.createMenu(menuNutrition);

    }


    @RequestMapping(value = "/deleteMenu",method = RequestMethod.DELETE)
    public void deleteMenu(Integer menuId){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        adminAccountService.deleteMenu(menuId);
    }
}
