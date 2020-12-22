package com.foodAssistant.domain.menu;

//Menu
public class MenuNutrition extends Menu{
    private Double protein;
    private Double calorie;
    private Double fat;
    private Double carbohydrate;

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
        return super.toString() + "  MenuNutrition{" +
                "protein=" + protein +
                ", calorie=" + calorie +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
