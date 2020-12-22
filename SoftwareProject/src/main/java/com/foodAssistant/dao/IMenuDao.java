package com.foodAssistant.dao;

import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.mysql.cj.exceptions.MysqlErrorNumbers;

import java.util.List;

/**
 * 处理和食物列表有关的操作
 */
public interface IMenuDao {
    /**
     * 查询全部食物列表
     * @return
     */
    List<MenuNutrition> getMenu();

    /**
     * 通过食物ID查询
     * @param foodId
     * @return
     */
    MenuNutrition getMenuById(Integer foodId);

    /**
     * 通过食物名称查询
     * @param foodName
     * @return
     */
    MenuNutrition getMenuByName(String foodName);

    /**
     * 通过食物类型查询
     * @param foodType
     * @return
     */
    List<Menu> getMenuByType(String foodType);

    /**
     * 创建新的食物列表项
     */
    void createMenu(MenuNutrition menuNutrition);

    /**
     * 删除已有的食物列表项
     */
    void deleteMenu(Integer menuID);

    /**
     * 更新已有的食物列表项
     */
    void updateMenu(Menu menu);
}
