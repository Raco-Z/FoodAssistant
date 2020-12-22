package com.foodAssistant.domain.account;

import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.domain.record.Record;
import io.swagger.models.auth.In;

import java.util.List;

public class UserAccount {
    //普通用户的ID
    private Integer accountId;
    //普通用户的名称
    private String accountName;
    //用户的推荐食谱
    private Menu recommendedFood;
    //用户推荐营养
    private Nutrition recommendedNutrition;
    //用户的饮食数据
    private List<Record> recordedFood;
    //密码
    private String accountPassword;
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

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public List<Record> getRecordedFood() {
        return recordedFood;
    }

    public void setRecordedFood(List<Record> recordedFood) {
        this.recordedFood = recordedFood;
    }
//private Integer priority;

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


    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", recommendedFood=" + recommendedFood +
                ", recommendedNutrition=" + recommendedNutrition +
                ", recordedFood=" + recordedFood +
                ", accountPassword='" + accountPassword + '\'' +
                ", height=" + height +
                ", Weight=" + Weight +
                '}';
    }
}
