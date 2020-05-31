package com.example.market2.dao;

import com.example.market2.entity.Category;
import com.example.market2.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods,Integer> {
    List<Goods> findAllByCategory(Category category);
    //List<Goods> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
