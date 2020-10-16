package com.foodAssistant.dao;

import com.foodAssistant.domain.Menu;

import java.util.List;

public interface IUserAccountDao {
    /**
     * 查询食谱
     */
    Menu getMenu();
    Menu getMenuById(Integer foodId);
    Menu getMenuByName(String foodName);
    List<Menu> getMenuByType(String foodType);

    /**
     * 增加饮食记录
     */
    void createRecord();

    /**
     * 删除饮食记录
     */
    void deleteRecord();

    /**
     * 修改饮食记录
     */
    void updateRecord();

    /**
     * 查询饮食记录
     * @return
     */
    List<Menu> getRecord();
}
