package com.foodAssistant.service;

import com.foodAssistant.domain.menu.Menu;

public interface IAdminAccount extends IAccountService{
    /**
     * 添加食物列表
     */
    void createMenu(Menu menu);

    /**
     * 删除食物列表
     */
    void deleteMenu(Integer menuId);

    /**
     * 修改食物列表
     */
    void updateMenu(Menu menu);

}
