package com.foodAssistant.dao;

import com.foodAssistant.domain.record.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理和饮食记录有关的操作
 */
@Repository("recordDao")
public interface IRecordDao {

    List<Record> getRecord();

    /**
     * 通过记录ID查询饮食记录
     */
    Record getRecordById(Integer recordId);

    /**
     * 获取用户的饮食记录
     * @param username
     * @return
     */
    List<Record> getRecordByUser(String username);

    List<Record> getRecordByFoodName(String foodName);

    /**
     * 新建饮食记录
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
}
