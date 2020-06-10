package com.example.market2.dao;

import com.example.market2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//使用了JPA中的JpaRepository<Goods,Integer>，只需使用对应方法，不用编写sql语句
public interface CategoryDao extends JpaRepository<Category,Integer> {
    //使用默认方法
}
