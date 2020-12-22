package com.foodAssistant.domain.record;

public class Record {
    private Integer recordId;
    private String userName;
    private String foodName;
    //食物的重量
    private Integer foodWeight;

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

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", userName='" + userName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodWeight=" + foodWeight +
                '}';
    }
}
