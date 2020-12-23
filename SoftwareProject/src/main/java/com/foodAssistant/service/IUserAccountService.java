package com.foodAssistant.service;

import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.menu.Nutrition;
import com.foodAssistant.domain.record.Record;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface IUserAccountService extends IAccountService{
    /**
     * 查询所有饮食记录
     */
    List<Record> getRecord();

    List<Record> getRecordByUser(String userName);

    /**
     * 查询一条饮食记录
     */
    Record getRecordById(Integer recordId);

    /**
     * 创建饮食记录
     */
    void createRecord(Record record);

    /**
     * 删除饮食记录
     */
    void deleteRecord(Integer recordId);

    /**
     * 更新饮食记录
     */
    void updateRecord(Record record);

    List<UserAccount> findAll();

    UserAccount findUserByName(String userName);

    void createUser(UserAccount user);

    Nutrition recommendNutrition(String userName);

    Nutrition calculateNutrition(String foodName,Integer foodWeight);

}
