package com.example.market2.controller;

import com.example.market2.entity.Goods;
import com.example.market2.entity.User;
import com.example.market2.result.Result;
import com.example.market2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.awt.print.Book;
import java.util.List;

@RestController
public class GoodsController {
    //注入实例
    GoodsService goodsService;
    @Autowired
    public void setGoodsService(GoodsService goodsService){
        this.goodsService = goodsService;
    }

    @CrossOrigin
    @GetMapping(value = "/api/goods")
    //获取数据库中商品的信息并返回
    public List<Goods> list() throws Exception{
        return goodsService.list();
    }

    @CrossOrigin
    @PostMapping("/api/goods")
    public Goods add(@RequestBody Goods goods) throws Exception{
        goodsService.add(goods);
        return goods;
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/goods")
    //按照分类的id
    public List<Goods> listByCategory(@PathVariable("cid") int cid) throws Exception {//@PathVariable可以用来映射URL中的占位符到目标方法的参数中
        if (0 != cid) {
            return goodsService.listByCategory(cid);//返回对应分类的list
        } else {
            return list();//返回全部的list
        }
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Goods goods) throws Exception {
        goodsService.deleteById(goods.getId());
    }
}
