package com.example.market2.service;

import com.example.market2.dao.RecordDao;
import com.example.market2.entity.Record;
import com.example.market2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    RecordDao recordDao;
    @Autowired
    public void setRecordDao(RecordDao recordDao){
        this.recordDao = recordDao;
    }
    public void add(Record record){
        recordDao.save(record);
    }
}
