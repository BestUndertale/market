package com.example.market2.service;

import com.example.market2.dao.CategoryDao;
import com.example.market2.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryDao categoryDao;
    @Autowired
    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id){
        Category c = categoryDao.findById(id).orElse(null);
        return c;
    }
}
