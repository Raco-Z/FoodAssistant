package com.foodAssistant.service;

import com.foodAssistant.domain.Menu;

import java.util.List;

public interface IUserAccountService extends IAccountService{
    /**
     * 创建饮食记录
     */
    void createRecord();

    /**
     * 删除饮食记录
     */
    void deleteRecord();

    /**
     * 更新饮食记录
     */
    void updateRecord();

}
