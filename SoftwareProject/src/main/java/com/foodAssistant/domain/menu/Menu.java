package com.foodAssistant.domain.menu;

import java.io.Serializable;

public class Menu implements Serializable{
    private Integer foodId;
    private String foodName;
    private String foodType;


    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}

