package com.foodAssistant.controller;


import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.factory.BeanFactory;
import com.foodAssistant.service.IAdminAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "menu接口",httpMethod = "GET",notes = "获取全部食谱")
    public List<MenuNutrition> getMenu() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<MenuNutrition> rtn = adminAccountService.getMenu();
        return rtn;
    }

    @RequestMapping(value = "/getMenuById",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "menu接口",httpMethod = "GET",notes = "获取指定ID食谱")
    @ApiImplicitParam(name = "foodId",value = "食谱ID",defaultValue = "1",paramType = "query",dataType = "Int",required = true)
    public Menu getMenuById(Integer foodId){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuById(foodId);
        return menu;
    }

    @RequestMapping(value = "/getMenuByName",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "menu接口",httpMethod = "GET",notes = "获取名称食谱")
    @ApiImplicitParam(name = "foodName",value = "食谱名称",defaultValue = "food1",paramType = "query",dataType = "String",required = true)
    public Menu getMenuByName(String foodName){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        Menu menu = adminAccountService.getMenuByName(foodName);
        return menu;
    }

    @RequestMapping(value = "/getMenuByType",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "menu接口",httpMethod = "GET",notes = "获取类型食谱")
    @ApiImplicitParam(name = "foodType",value = "食谱类型",defaultValue = "A",paramType = "query",dataType = "String",required = true)
    public List<Menu> getMenuByType(String foodType){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        List<Menu> menus = adminAccountService.getMenuByType(foodType);
        return menus;
    }

    @RequestMapping(value = "/createMenu",method = RequestMethod.POST)
    @ApiOperation(value = "menu接口",httpMethod = "POST",notes = "创建食谱")
    @ApiImplicitParam(name = "menuNutrition",value = "食谱详情",paramType = "body",dataType = "MenuNutrition",required = true)
    public void createMenu(@RequestBody MenuNutrition menuNutrition){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        adminAccountService.createMenu(menuNutrition);

    }

    //会报404，但可以操作数据库
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.DELETE)
    @ApiOperation(value = "menu接口",httpMethod = "DELETE",notes = "删除食谱")
    @ApiImplicitParam(name = "menuId",value = "食谱ID",paramType = "query",dataType = "Int",required = true)
    public void deleteMenu(Integer menuId){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        IAdminAccountService adminAccountService = ac.getBean("adminAccountService",IAdminAccountService.class);
        adminAccountService.deleteMenu(menuId);
    }
}
