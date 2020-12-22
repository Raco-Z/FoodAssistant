package com.foodAssistant.dao.impl;

import com.foodAssistant.dao.IRecordDao;
import com.foodAssistant.domain.menu.Menu;
import com.foodAssistant.domain.record.Record;
import com.foodAssistant.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 处理饮食记录的实现类
 */
public class RecordDao implements IRecordDao {

    private ConnectionUtils connectionUtils;

    private QueryRunner queryRunner;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Record> getRecord() {
        try{
            return queryRunner.query(connectionUtils.getConnection()
                    , "select * from Record;"
                    ,new BeanListHandler<Record>(Record.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Record getRecordById(Integer recordId) {
        try{
            return queryRunner.query(connectionUtils.getConnection()
                    ,"select m.id as foodId,m.foodname,m.foodtype from Menu m;"
                    ,new BeanHandler<Record>(Record.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createRecord(Record record) {

    }

    public void deleteRecord(Integer recordId) {

    }

    public void updateRecord(Record record) {

    }
}
