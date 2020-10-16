package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IAccountDao;
import com.foodAssistant.domain.Menu;
import com.foodAssistant.service.IAdminAccount;

import java.util.List;

public class AdminAccount implements IAdminAccount {

    private IAccountDao adminAccountDao;

    public void setAdminAccountDao(IAccountDao adminAccountDao) {
        this.adminAccountDao = adminAccountDao;
    }

    public void createMenu() {
        adminAccountDao.create();
    }

    public void deleteMenu() {
        adminAccountDao.delete();
    }

    public void updateMenu() {
        adminAccountDao.update();
    }

    public List<Menu> getMenu() {
        return adminAccountDao.getMenu();
    }

    public Menu getMenuByName(String foodName) {
        return adminAccountDao.getMenuByName(foodName);
    }

    public Menu getMenuById(Integer foodId) {
        return adminAccountDao.getMenuById(foodId);
    }

    public List<Menu> getMenuByType(String foodType) {
        return adminAccountDao.getMenuByType(foodType);
    }
}
