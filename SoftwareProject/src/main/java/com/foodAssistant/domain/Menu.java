package com.foodAssistant.domain;

public class Menu {
    private Integer foodId;
    private String foodName;
    private String foodType;
    private Nutrition foodNutrition;

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

    public Nutrition getFoodNutrition() {
        return foodNutrition;
    }

    public void setFoodNutrition(Nutrition foodNutrition) {
        this.foodNutrition = foodNutrition;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodNutrition=" + foodNutrition +
                '}';
    }
}

