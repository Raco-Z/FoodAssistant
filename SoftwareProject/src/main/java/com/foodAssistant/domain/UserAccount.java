package com.foodAssistant.domain;

public class UserAccount {
    private Integer accountId;
    private String accountName;
    private Menu recommendedFood;
    private Menu recordedFood;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer id) {
        accountId = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Menu getRecommendedFood() {
        return recommendedFood;
    }

    public void setRecommendedFood(Menu recommendedFood) {
        this.recommendedFood = recommendedFood;
    }

    public Menu getRecordedFood() {
        return recordedFood;
    }

    public void setRecordedFood(Menu recordedFood) {
        this.recordedFood = recordedFood;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", recommendedFood=" + recommendedFood +
                ", recordedFood=" + recordedFood +
                '}';
    }
}
