package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IUserDao;
import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.record.Record;

import java.util.List;

public class UserDao implements IUserDao {
    public UserAccount findUserByName(String username) {
        return null;
    }

    public List<UserAccount> findAll() {
        return null;
    }

    public void createUser(UserAccount user) {

    }

    public void record(Record record) {

    }

    public List<Record> findAllRecord(String userName) {
        return null;
    }

    public void recommendNutrition() {

    }
}
