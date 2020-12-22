package com.foodAssistant.domain.account;

import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.MenuNutrition;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.domain.record.Record;

import java.util.List;

public class UserAccount {
    //普通用户的ID
    private Integer accountId;
    //普通用户的名称
    private String accountName;
    //普通用户的密码
    private String accountPassword;
    //用户推荐营养
    private Nutrition recommendedNutrition;
    //用户的饮食数据
    private List<Record> recordedFood;
    //身高
    private Integer height;
    //体重
    private Integer Weight;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Nutrition getRecommendedNutrition() {
        return recommendedNutrition;
    }

    public void setRecommendedNutrition(Nutrition recommendedNutrition) {
        this.recommendedNutrition = recommendedNutrition;
    }

    public List<Record> getRecordedFood() {
        return recordedFood;
    }

    public void setRecordedFood(List<Record> recordedFood) {
        this.recordedFood = recordedFood;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer id) {
        accountId = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) { this.accountName = accountName; }

    public String getAccountPassword() { return accountPassword; }

    public void setAccountPassword(String accountPassword) { this.accountPassword = accountPassword; }

    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", recommendedNutrition=" + recommendedNutrition +
                ", recordedFood=" + recordedFood +
                ", height=" + height +
                ", Weight=" + Weight +
                '}';
    }
}
