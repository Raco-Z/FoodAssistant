package com.foodAssistant.controller;

import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.domain.record.Record;
import com.foodAssistant.service.IUserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //保存身高体重
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public @ResponseBody String saveInfo(@RequestParam("username")String username, @RequestParam("height") String height, @RequestParam("weight") String weight)
    {
        UserAccount userAccount = iUserAccountService.findUserByName(username);
        userAccount.setHeight(Integer.parseInt(height));
        userAccount.setWeight(Integer.parseInt(weight));
        iUserAccountService.updateUser(userAccount);
        return "save successfully";
    }

    /*列出食物营养表*/
    @RequestMapping(value = "/listMenu", method = RequestMethod.POST)
    public @ResponseBody String listMenu(@RequestBody String foodName)
    {
        //验证方法执行
        System.out.println("listMenu done");
        System.out.println(foodName);
        //在数据库中查询值，并返回对应的食物的营养项
        MenuNutrition foodNutrition = iUserAccountService.getMenuByName(foodName);
        if (foodNutrition==null)
        {
            return null;
        }
        String rtn = foodNutrition.toString();
        //List<MenuNutrition> menu = new ArrayList<>();
        //menu.add(foodNutrition);
        return rtn;
    }

    /*记录输入的饮食数据*/
    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
    public @ResponseBody String saveRecord(@RequestParam("username") String username, @RequestParam("foodName") String foodName, @RequestParam("foodWeight") String foodWeight)
    {
        System.out.println("saveRecord done");
        Record record = new Record();
        record.setUserName(username);
        record.setFoodName(foodName);
        record.setFoodWeight(Integer.parseInt(foodWeight));
        iUserAccountService.createRecord(record);
        List<Record> list = iUserAccountService.getRecordByUser(username);
        for(Record r: list)
        {
            Nutrition nutrition1 = iUserAccountService.calculateNutrition(r.getFoodName(), r.getFoodWeight());
            r.setProtein(nutrition1.getProtein());
            r.setCalorie(nutrition1.getCalorie());
            r.setCarbohydrate(nutrition1.getCarbohydrate());
            r.setFat(nutrition1.getFat());
        }
        String rtn = list.toString();
        return rtn;
    }

    /*显示推荐食谱，以表格形式展示*/
    @RequestMapping(value = "/showRecommendMenu", method = RequestMethod.POST)
    public @ResponseBody String showRecommendMenu(@RequestBody String username)
    {
        //验证方法执行
        System.out.println("showRecommendMenu");
        iUserAccountService.recommendNutrition(username);
        Nutrition nutrition = iUserAccountService.recommendNutrition(username);
        String rtn = nutrition.toString();
        return rtn;
    }

    /*根据输入的食物名字和重量，计算食物营养*/
    @RequestMapping(value = "/calNutrition", method = RequestMethod.POST)
    public @ResponseBody String calculateNutrition(@RequestParam("foodName") String foodName, @RequestParam("foodWeight") String foodWeight)
    {
        System.out.println("calculateNutrition done");
        Nutrition nutrition = iUserAccountService.calculateNutrition(foodName, Integer.parseInt(foodWeight));
        String rtn = nutrition.toString();
        return rtn;
    }
}
