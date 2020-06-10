package com.example.market2.dao;

import com.example.market2.entity.Category;
import com.example.market2.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//使用了JPA中的JpaRepository<Goods,Integer>，只需使用对应方法，不用编写sql语句
public interface GoodsDao extends JpaRepository<Goods,Integer> {
    List<Goods> findAllByCategory(Category category);//通过分类寻找

}
