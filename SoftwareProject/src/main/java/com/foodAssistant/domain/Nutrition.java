package com.foodAssistant.domain;

public class Nutrition {
    private Integer protein;
    private Integer calorie;
    private Integer fat;

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "protein=" + protein +
                ", calorie=" + calorie +
                ", fat=" + fat +
                '}';
    }
}
