package com.foodAssistant.dao;

import com.foodAssistant.domain.record.Record;

import java.util.List;

/**
 * 处理和饮食记录有关的操作
 */
public interface IRecordDao {

    List<Record> getRecord();

    /**
     * 通过记录ID查询饮食记录
     */
    Record getRecordById(Integer recordId);

    /**
     * 新建饮食记录
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
