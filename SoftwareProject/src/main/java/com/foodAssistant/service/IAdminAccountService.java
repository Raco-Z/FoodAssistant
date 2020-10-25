package com.foodAssistant.service;

<<<<<<< HEAD:SoftwareProject/src/main/java/com/foodAssistant/service/IAdminAccount.java
import com.foodAssistant.domain.menu.Menu;

public interface IAdminAccount extends IAccountService{
=======
public interface IAdminAccountService extends IAccountService{
>>>>>>> master:SoftwareProject/src/main/java/com/foodAssistant/service/IAdminAccountService.java
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
