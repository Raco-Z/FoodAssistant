package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IMenuDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.factory.BeanFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理食物列表的实现类
 */
public class MenuDao implements IMenuDao {

    private Menu m = (Menu) BeanFactory.getBean("menu");

    public List<Menu> getMenu() {
        m.setFoodId(001);
        m.setFoodName("chicken");
        Nutrition n = (Nutrition)BeanFactory.getBean("nutrition");
        n.setCalorie(0);
        n.setFat(1);
        n.setProtein(2);
        m.setFoodNutrition(n);
        m.setFoodType("Meat");
        List<Menu> ml = new ArrayList<>();
        ml.add(m);
        return ml;
    }

    public Menu getMenuById(Integer foodId) {
        return null;
    }

    public Menu getMenuByName(String foodName) {
        return null;
    }

    public List<Menu> getMenuByType(String foodType) {
        return null;
    }

    public void createMenu() {

    }

    public void deleteMenu() {

    }

    public void updateMenu() {

    }
}
