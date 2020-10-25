package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 处理食物列表的实现类
 */
public class MenuDao implements IMenuDao {
<<<<<<< HEAD
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }
=======
>>>>>>> master

    public List<Menu> getMenu() {
        try{
            return queryRunner.query("select * from Menu;",new BeanListHandler<Menu>(Menu.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Menu getMenuById(Integer foodId) {
        try{
            return queryRunner.query("select * from Menu where id = ?;",new BeanHandler<Menu>(Menu.class),foodId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Menu getMenuByName(String foodName) {
        try{
            return queryRunner.query("select * from Menu where name = ?;",new BeanHandler<Menu>(Menu.class),foodName);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Menu> getMenuByType(String foodType) {
        try{
            return queryRunner.query("select * from Menu where type = ?;",new BeanListHandler<Menu>(Menu.class),foodType);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createMenu(Menu menu) {
        try{
            queryRunner.update("insert into Menu(name,type,protein,calorie,fat) values(?,?,?,?,?);",
                    menu.getFoodName(),menu.getFoodType(),menu.getFoodNutrition().getProtein(),menu.getFoodNutrition().getCalorie(),menu.getFoodNutrition().getFat());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteMenu(Integer menuId) {
        try{
            queryRunner.update("delete from Menu where id=?;",menuId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateMenu(Menu menu) {
        try{
            queryRunner.update("update Menu set name=?,Type=?,protein=?,calorie=?,fat=? where id=? ",
                    menu.getFoodName(),menu.getFoodType(),menu.getFoodNutrition().getProtein(),menu.getFoodNutrition().getCalorie(),menu.getFoodNutrition().getFat(),menu.getFoodId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
