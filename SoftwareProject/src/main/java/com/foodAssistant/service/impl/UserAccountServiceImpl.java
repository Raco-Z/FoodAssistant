package com.foodAssistant.service.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.dao.IRecordDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.domain.record.Record;
import com.foodAssistant.service.IUserAccountService;

import java.util.List;

/**
 * 用户业务层实现类
 */
public class UserAccountServiceImpl implements IUserAccountService {
    private IMenuDao menuDao;
    private IRecordDao recordDao;

    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setRecordDao(IRecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<MenuNutrition> getMenu(){
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

    public List<Record> getRecord() {
        return recordDao.getRecord();
    }

    public Record getRecordById(Integer recordId) {
        return recordDao.getRecordById(recordId);
    }

    public void createRecord() {
        recordDao.createRecord();
    }

    public void deleteRecord() {
        recordDao.deleteRecord();
    }

    public void updateRecord() {
        recordDao.updateRecord();
    }
}
