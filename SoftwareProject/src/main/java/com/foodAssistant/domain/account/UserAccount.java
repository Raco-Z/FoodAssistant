package com.foodAssistant.domain.account;

import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.record.Record;

public class UserAccount {
    //普通用户的ID
    private Integer accountId;
    //普通用户的名称
    private String accountName;
    //普通用户的密码
    private String accountPassword;
    //用户的推荐食谱
    private Menu recommendedFood;
    //用户的饮食数据
    private Record recordedFood;
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

    public void setAccountName(String accountName) { this.accountName = accountName; }

    public Menu getRecommendedFood() {
        return recommendedFood;
    }

    public void setRecommendedFood(Menu recommendedFood) {
        this.recommendedFood = recommendedFood;
    }

    public Record getRecordedFood() {
        return recordedFood;
    }

    public void setRecordedFood(Record recordedFood) {
        this.recordedFood = recordedFood;
    }

    public String getAccountPassword() { return accountPassword; }

    public void setAccountPassword(String accountPassword) { this.accountPassword = accountPassword; }

    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", recommendedFood=" + recommendedFood +
                ", recordedFood=" + recordedFood +
                '}';
    }
}
