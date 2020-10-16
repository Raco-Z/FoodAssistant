package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.service.IAdminAccount;

import java.util.List;

public class AdminAccount implements IAdminAccount {
    private IMenuDao menuDao;

    public void createMenu() {
        menuDao.createMenu();
    }

    public void deleteMenu() {
        menuDao.deleteMenu();
    }

    public void updateMenu() {
        menuDao.updateMenu();
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
