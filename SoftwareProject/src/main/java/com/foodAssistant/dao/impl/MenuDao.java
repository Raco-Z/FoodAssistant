package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.utils.ConnectionUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 处理食物列表的实现类
 */

public class MenuDao implements IMenuDao {

    private ConnectionUtils connectionUtils;

    //使用dbutils进行JDBC操作
    private QueryRunner queryRunner;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Menu> getMenu() {
        try{
            return queryRunner.query(connectionUtils.getConnection(),"select m.id as foodId,m.foodname,m.foodtype from Menu m;",new BeanListHandler<Menu>(Menu.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Menu getMenuById(Integer foodId) {
        try{
            return queryRunner.query(connectionUtils.getConnection(),"select  m.id as foodId,m.foodname,m.foodtype from Menu m where id = ?;",new BeanHandler<Menu>(Menu.class),foodId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Menu getMenuByName(String foodName) {
        try{
            return queryRunner.query(connectionUtils.getConnection(),"select  m.id as foodId,m.foodname,m.foodtype from Menu m where foodname = ?;",new BeanHandler<Menu>(Menu.class),foodName);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Menu> getMenuByType(String foodType) {
        try{
            return queryRunner.query(connectionUtils.getConnection(),"select  m.id as foodId,m.foodname,m.foodtype from Menu m where foodtype = ?;",new BeanListHandler<Menu>(Menu.class),foodType);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createMenu(Menu menu) {
        try{
            queryRunner.update("insert into Menu(foodname,foodtype,protein,calorie,fat) values(?,?,?,?,?);",
                    menu.getFoodName(),menu.getFoodType(),menu.getFoodNutrition().getProtein(),menu.getFoodNutrition().getCalorie(),menu.getFoodNutrition().getFat());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteMenu(Integer menuId) {
        try{
            queryRunner.update(connectionUtils.getConnection(),"delete from Menu where id=?;",menuId);
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
