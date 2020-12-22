package com.foodAssistant.dao;

import com.foodAssistant.domain.account.UserAccount;
import com.foodAssistant.domain.record.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface IUserDao {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    UserAccount findUserByName(String username);

    /**
     * 通过用户ID查询
     * @param userId
     * @return
     */
    UserAccount getUserById(Integer userId);

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
     * 更新用户
     * @param user
     */
    void updateUser(UserAccount user);

}
