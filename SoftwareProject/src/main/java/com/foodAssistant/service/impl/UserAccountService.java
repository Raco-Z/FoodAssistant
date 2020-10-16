package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IUserAccountDao;
import com.foodAssistant.domain.Menu;
import com.foodAssistant.service.IUserAccountService;

import java.util.List;

public class UserAccountService implements IUserAccountService {
    private IUserAccountDao userAccountDao;

    public void setAccountDao(IUserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
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

    public void record() {

    }
}
