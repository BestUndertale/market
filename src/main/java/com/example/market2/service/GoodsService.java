package com.example.market2.service;

import com.example.market2.dao.GoodsDao;
import com.example.market2.entity.Category;
import com.example.market2.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    GoodsDao goodsDao;
    @Autowired
    public void setGoodsDao(GoodsDao goodsDao){
        this.goodsDao = goodsDao;
    }

    CategoryService categoryService;
    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public List<Goods> list(){//寻找全部商品
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return goodsDao.findAll(sort);
    }

    public List<Goods> listByCategory(int cid){//按分类寻找
        Category category = categoryService.get(cid);
        return goodsDao.findAllByCategory(category);
    }
}
