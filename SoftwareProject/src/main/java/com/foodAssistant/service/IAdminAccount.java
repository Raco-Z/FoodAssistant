package com.foodAssistant.service;

public interface IAdminAccount extends IAccountService{
    /**
     * 添加食物列表
     */
    void createMenu();

    /**
     * 删除食物列表
     */
    void deleteMenu();

    /**
     * 修改食物列表
     */
    void updateMenu();

}
