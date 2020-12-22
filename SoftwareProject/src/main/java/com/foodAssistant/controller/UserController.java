package com.foodAssistant.controller;


import com.foodAssistant.domain.account.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

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

    /*记录输入的饮食数据*/
    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
    public String saveRecord()
    {
        System.out.println("saveRecord done");
        return "success";
    }

    /*列出食物营养表*/
    @RequestMapping(value = "/listMenu", method = RequestMethod.GET)
    public String listMenu()
    {
        System.out.printf("listMenu done");
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
