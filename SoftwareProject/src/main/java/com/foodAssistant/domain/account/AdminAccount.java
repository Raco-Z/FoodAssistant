package com.foodAssistant.domain.account;

public class AdminAccount {
    //管理员用户的ID
    private Integer accountId;
    //管理员用户的名称
    private String accountName;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
