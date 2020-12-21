package com.foodAssistant.domain.record;

public class Record {
    private Integer recordId;
    private String foodName;



    public Integer getRecordId() {
        return recordId;
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
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
