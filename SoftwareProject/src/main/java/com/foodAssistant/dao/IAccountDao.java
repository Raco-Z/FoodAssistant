package com.foodAssistant.dao;

import com.foodAssistant.domain.Menu;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询食谱
     */
    List<Menu> getMenu();
    Menu getMenuById(Integer foodId);
    Menu getMenuByName(String foodName);
    List<Menu> getMenuByType(String foodType);

    /**
     * 增加饮食记录
     */
    void create();

    /**
     * 删除饮食记录
     */
    void delete();

    /**
     * 修改饮食记录
     */
    void update();

}
