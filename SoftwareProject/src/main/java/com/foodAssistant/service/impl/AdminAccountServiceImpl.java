package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.dao.impl.MenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.service.IAccountService;
import com.foodAssistant.service.IAdminAccountService;

import java.util.List;

/**
 * 管理员业务层实现类
 */
public class AdminAccountServiceImpl implements IAdminAccountService {
    private IMenuDao menuDao ;

    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void createMenu(MenuNutrition menu) {
        menuDao.createMenu(menu);
    }

    public void deleteMenu(Integer menuId) {
        menuDao.deleteMenu(menuId);
    }

    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    //使用子类的方式封装数据
    public List<MenuNutrition> getMenu() {
        return menuDao.getMenu();
    }

    //暂未修改
    public Menu getMenuByName(String foodName) {
        return menuDao.getMenuByName(foodName);
    }

    //暂未修改
    public Menu getMenuById(Integer foodId) {
        return menuDao.getMenuById(foodId);
    }

    //暂未修改
    public List<Menu> getMenuByType(String foodType) {
        return menuDao.getMenuByType(foodType);
    }
}
