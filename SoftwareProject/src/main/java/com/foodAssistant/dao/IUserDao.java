package com.foodAssistant.dao;

import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.record.Record;

import java.util.List;

public interface IUserDao {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    UserAccount findUserByName(String username);

    /**
     * 查询全部用户
     * @return
     */
    List<UserAccount> findAll();

    /**
     * 创建新用户
     * @return
     */
    void createUser(UserAccount user);

    /**
     * 记录饮食
     * @return
     */
    void record(Record record);

    /**
     * 查询所有饮食记录
     * @return
     */
    List<Record> findAllRecord(String userName);

    /**
     * 生成推荐营养
     * @return
     */
    void recommendNutrition();
}
