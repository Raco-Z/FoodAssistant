package com.foodAssistant.controller;


import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.factory.BeanFactory;
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
    public List<Menu> findAllMenu() throws ClassNotFoundException {
        System.out.println("findAllMenu done");
        IMenuDao md = (IMenuDao)BeanFactory.getBean("menuDao");
        List<Menu> rtn = md.getMenu();
        System.out.println(rtn);
        return rtn;
    }
}
