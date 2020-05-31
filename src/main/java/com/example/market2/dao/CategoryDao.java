package com.example.market2.dao;

import com.example.market2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
