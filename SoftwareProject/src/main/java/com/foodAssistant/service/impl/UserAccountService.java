package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IAccountDao;
import com.foodAssistant.dao.impl.AccountDao;
import com.foodAssistant.domain.Menu;
import com.foodAssistant.service.IUserAccountService;

import java.util.List;

public class UserAccountService implements IUserAccountService {
    private IAccountDao userAccountDao;

    public void setAccountDao(IAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    public List<Menu> getMenu(){
        return userAccountDao.getMenu();
    }

    public Menu getMenuByName(String foodName) {
        return userAccountDao.getMenuByName(foodName);
    }

    public Menu getMenuById(Integer foodId) {
        return userAccountDao.getMenuById(foodId);
    }

    public List<Menu> getMenuByType(String foodType) {
        return userAccountDao.getMenuByType(foodType);
    }

    public void createRecord() {
        userAccountDao.create();
    }

    public void deleteRecord() {
        userAccountDao.delete();
    }

    public void updateRecord() {
        userAccountDao.update();
    }
}
