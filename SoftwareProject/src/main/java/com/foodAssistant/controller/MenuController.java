package com.foodAssistant.controller;


import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.factory.BeanFactory;
import com.foodAssistant.service.IAdminAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class MenuController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenu() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<Menu> rtn = adminAccountService.getMenu();
        return rtn;
    }

    @RequestMapping(value = "/getMenuById",method = RequestMethod.GET)
    @ResponseBody
    public Menu getMenuById(Integer foodId){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuById(foodId);
        return menu;
    }

    @RequestMapping(value = "/getMenuByName",method = RequestMethod.GET)
    @ResponseBody
    public Menu getMenuByName(String foodName){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuByName(foodName);
        return menu;
    }

    @RequestMapping(value = "/getMenuByType",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenuByType(String foodType){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<Menu> menus = adminAccountService.getMenuByType(foodType);
        return menus;
    }


}
