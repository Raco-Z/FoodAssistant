package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.dao.IRecordDao;
import com.foodAssistant.dao.IUserDao;
import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.domain.record.Record;
import com.foodAssistant.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层实现类
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements IUserAccountService {

    @Autowired
    private IMenuDao menuDao;

    @Autowired
    private IRecordDao recordDao;

    @Autowired
    private IUserDao userDao;

    public List<MenuNutrition> getMenu(){
        return menuDao.getMenu();
    }

    public MenuNutrition getMenuByName(String foodName) {
        return menuDao.getMenuByName(foodName);
    }

    public MenuNutrition getMenuById(Integer foodId) {
        return menuDao.getMenuById(foodId);
    }

    public List<MenuNutrition> getMenuByType(String foodType) {
        return menuDao.getMenuByType(foodType);
    }

    public List<Record> getRecord() {
        return recordDao.getRecord();
    }

    public List<Record> getRecordByUser(String username) {
        return recordDao.getRecordByUser(username);
    }

    public Record getRecordById(Integer recordId) {
        return recordDao.getRecordById(recordId);
    }

    public void createRecord(Record record) {
        recordDao.createRecord(record);
    }

    public void deleteRecord(Integer recordId) {
        recordDao.deleteRecord(recordId);
    }

    public void updateRecord(Record record) {
        recordDao.updateRecord(record);
    }

    public List<UserAccount> findAll() {
        return userDao.findAll();
    }

    public UserAccount findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    public void createUser(UserAccount user) {
        userDao.createUser(user);
    }

    public void updateUser(UserAccount user)
    {
        userDao.updateUser(user);
    }

    //生成推荐
    public Nutrition recommendNutrition(String userName) {
        //返回需要摄入的营养
        UserAccount user = userDao.findUserByName(userName);
        Nutrition n = new Nutrition();
        Double recommendCalorie = (double)10 * user.getHeight() + user.getWeight();
        Double recommendProtein = 0.3 * recommendCalorie / 4;
        Double recommendFat = 0.2 * recommendCalorie / 9;
        Double recommendCarbohydrate = 0.5 * recommendCalorie / 4;
        n.setCalorie(recommendCalorie);
        n.setProtein(recommendProtein);
        n.setFat(recommendFat);
        n.setCarbohydrate(recommendCarbohydrate);
        user.setRecommendedNutrition(n);
        return n;
    }

    //获取食物中的总营养
    @Override
    public Nutrition calculateNutrition(String foodName, Integer foodWeight) {
        MenuNutrition menu = menuDao.getMenuByName(foodName);
        Nutrition n = new Nutrition();
        Double totalCalorie = menu.getCalorie() * foodWeight;
        Double totalProtein = menu.getProtein() * foodWeight;
        Double totalFat = menu.getFat() * foodWeight;
        Double totalCarbohydrate = menu.getCarbohydrate() * foodWeight;
        n.setCalorie(totalCalorie);
        n.setProtein(totalProtein);
        n.setFat(totalFat);
        n.setCarbohydrate(totalCarbohydrate);
        return n;
    }
}
