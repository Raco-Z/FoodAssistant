package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.service.IAccountService;
import com.foodAssistant.service.IAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员业务层实现类
 */
@Service("adminAccountService")
public class AdminAccountServiceImpl implements IAdminAccountService {

    @Autowired
    private IMenuDao menuDao ;


    public void createMenu(MenuNutrition menu) {
        menuDao.createMenu(menu);
    }

    public void deleteMenu(Integer menuId) {
        menuDao.deleteMenu(menuId);
    }


    public void updateMenu(MenuNutrition menuNutrition) {
        menuDao.updateMenu(menuNutrition);
    }

    //使用子类的方式封装数据
    public List<MenuNutrition> getMenu() {
        return menuDao.getMenu();
    }

    //暂未修改
    public MenuNutrition getMenuByName(String foodName) {
        return menuDao.getMenuByName(foodName);
    }

    //暂未修改
    public MenuNutrition getMenuById(Integer foodId) {
        return menuDao.getMenuById(foodId);
    }

    //暂未修改
    public List<MenuNutrition> getMenuByType(String foodType) {
        return menuDao.getMenuByType(foodType);
    }
}
