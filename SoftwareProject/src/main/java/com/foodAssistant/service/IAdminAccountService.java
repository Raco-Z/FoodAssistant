package com.foodAssistant.service;


import com.foodAssistant.domain.menu.Menu;

/**
 * 管理员业务层接口
 */
public interface IAdminAccountService extends IAccountService{

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
