package com.foodAssistant.service;

import com.foodAssistant.domain.Menu;

import java.util.List;

public interface IAccountService {
    /**
     * 查询食物列表、饮食记录
     */
    List<Menu> getMenu();
    Menu getMenuByName(String foodName);
    Menu getMenuById(Integer foodId);
    List<Menu> getMenuByType(String foodType);
}
