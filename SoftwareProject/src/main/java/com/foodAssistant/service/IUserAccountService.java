package com.foodAssistant.service;

import com.foodAssistant.domain.Menu;

import java.util.List;

public interface IUserAccountService {

    /**
     * 查询食物列表
     */
    Menu getMenuByName(String foodName);
    Menu getMenuById(Integer foodId);
    List<Menu> getMenuByType(String foodType);

    /**
     * 记录饮食数据
     */
    void record();

}
