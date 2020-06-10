package com.example.market2.dao;

import com.example.market2.entity.Record;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordDao extends JpaRepository<Record,Integer> {
    Record findByName(String  name);
    Record getByName(String  name);
}
