package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
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

    public List<MenuNutrition> getMenu() {
        try{
            return queryRunner.query(connectionUtils.getConnection()
                    ,"select m.id as foodId,m.foodname,m.foodtype,n.protein,n.calorie,n.fat from Menu m,nutrition n where m.id=n.fid;"
                    ,new BeanListHandler<MenuNutrition>(MenuNutrition.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MenuNutrition getMenuById(Integer foodId) {
        try{
            return queryRunner.query(connectionUtils.getConnection()
                    ,"select  m.id as foodId,m.foodname,m.foodtype from Menu m where id = ?;"
                    ,new BeanHandler<MenuNutrition>(MenuNutrition.class),foodId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MenuNutrition getMenuByName(String foodName) {
        MenuNutrition mn = new MenuNutrition();
        mn.setFoodId(1);
        mn.setFoodName(foodName);
        mn.setFoodType("zbc");
        mn.setCalorie(10);
        mn.setFat(20);
        mn.setProtein(30);
        return mn;
        /*try{
            return queryRunner.query(connectionUtils.getConnection(),"select  m.id as foodId,m.foodname,m.foodtype from Menu m where foodname = ?;",new BeanHandler<MenuNutrition>(MenuNutrition.class),foodName);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }

    public List<Menu> getMenuByType(String foodType) {
        try{
            return queryRunner.query(connectionUtils.getConnection(),"select  m.id as foodId,m.foodname,m.foodtype from Menu m where foodtype = ?;",new BeanListHandler<Menu>(Menu.class),foodType);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void createMenu(MenuNutrition menuNutrition) {
        try{
            //可以使用Mybatis大幅简化
            queryRunner.update(connectionUtils.getConnection(),
                    "insert into Menu(foodname,foodtype) values(?,?);",
                    menuNutrition.getFoodName(),menuNutrition.getFoodType());
            Menu menu = queryRunner.query(connectionUtils.getConnection(),
                    "select m.id as foodId from menu m where m.foodname=?",
                    new BeanHandler<Menu>(Menu.class),
                    menuNutrition.getFoodName());
            queryRunner.update(connectionUtils.getConnection(),
                    "insert into nutrition(fid,protein,calorie,fat) values(?,?,?,?)"
                    ,menu.getFoodId(),menuNutrition.getProtein(),menuNutrition.getCalorie(),menuNutrition.getFat());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteMenu(Integer menuId) {
        try{

            queryRunner.update(connectionUtils.getConnection(),"delete from nutrition where fid=?",menuId);
            queryRunner.update(connectionUtils.getConnection(),"delete from Menu where id=?;",menuId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateMenu(Menu menu) {
        try{
            queryRunner.update(connectionUtils.getConnection(),"update Menu set foodname=?,foodtype=? where id=? ",
                    menu.getFoodName(),menu.getFoodType(),menu.getFoodId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
