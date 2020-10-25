package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.service.IAdminAccountService;

import java.util.List;

public class AdminAccountServiceImpl implements IAdminAccountService {
    private IMenuDao menuDao;

    public void createMenu(Menu menu) {
        menuDao.createMenu(menu);
    }

    public void deleteMenu(Integer menuId) {
        menuDao.deleteMenu(menuId);
    }

    public void updateMenu(Menu menu) {
        menuDao.updateMenu(menu);
    }

    public List<Menu> getMenu() {
        return menuDao.getMenu();
    }

    public Menu getMenuByName(String foodName) {
        return menuDao.getMenuByName(foodName);
    }

    public Menu getMenuById(Integer foodId) {
        return menuDao.getMenuById(foodId);
    }

    public List<Menu> getMenuByType(String foodType) {
        return menuDao.getMenuByType(foodType);
    }
}
