package com.foodAssistant.controller;


import com.foodAssistant.domain.account.AdminAccount;
import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.service.IUserAccountService;
import com.foodAssistant.service.impl.UserAccountServiceImpl;
import javafx.application.Application;
import javafx.scene.input.Mnemonic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login/user")
public class UserController {



    @Resource(name = "userAccountService")
    IUserAccountService iUserAccountService;

    /*用户可以修改用户名username，可以保存*/
    /*@RequestMapping(value = "/saveName", method = RequestMethod.POST)
    public String saveName(Model model){
        UserAccount user = (UserAccount) model.getAttribute("user");
        assert user != null;

        user.setAccountName("changed");
        model.addAttribute("user", user);
        System.out.println("saveName done");
        return "success";
    }*/

    /*列出食物营养表*/
    @RequestMapping(value = "/listMenu", method = RequestMethod.POST)
    public @ResponseBody List<MenuNutrition> listMenu(@RequestBody Menu mn)
    {
        //验证方法执行
        System.out.println("listMenu done");
        System.out.println(mn);
        //判断输入是否为空，如果为空则返回整张表
        if (mn.getFoodName().isEmpty())
        {
            List<MenuNutrition> menu = iUserAccountService.getMenu();
            return menu;
        }
        //如果不为空，则返回对应的食物的营养项
        MenuNutrition foodNutrition = iUserAccountService.getMenuByName(mn.getFoodName());
        List<MenuNutrition> menu = new ArrayList<>();
        menu.add(foodNutrition);
        return menu;
    }

    /*记录输入的饮食数据*/
    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
    public String saveRecord()
    {
        System.out.println("saveRecord done");
        return "success";
    }

    /*显示推荐食谱，以表格形式展示*/
    @RequestMapping(value = "/showRecommendMenu", method = RequestMethod.GET)
    public String showRecommendMenu()
    {
        System.out.println("showRecommendMenu");
        return "success";
    }

    /*根据输入的食物名字和重量，计算食物营养*/
    @RequestMapping(value = "/calculateNutrition", method = RequestMethod.GET)
    public String calculateNutrition()
    {
        System.out.println("calculateNutrition done");
        return "success";
    }
}
