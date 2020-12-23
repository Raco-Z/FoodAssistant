package com.foodAssistant.domain.record;

import com.foodAssistant.domain.menu.Nutrition;

public class Record{
    private Integer recordId;
    private String userName;
    private String foodName;
    //食物的重量
    private Integer foodWeight;
    private Double protein;
    private Double calorie;
    private Double fat;
    private Double carbohydrate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Integer getRecordId() {
        return recordId;
    }

    public Integer getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(Integer foodWeight) {
        this.foodWeight = foodWeight;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", userName='" + userName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodWeight=" + foodWeight +
                ", protein=" + protein +
                ", calorie=" + calorie +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
