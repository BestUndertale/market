package com.example.market2.controller;

import com.example.market2.entity.Goods;
import com.example.market2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class GoodsController {
    GoodsService goodsService;
    @Autowired
    public void setGoodsService(GoodsService goodsService){
        this.goodsService = goodsService;
    }

    @CrossOrigin
    @GetMapping(value = "/api/goods")
    public List<Goods> list() throws Exception{
        return goodsService.list();
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Goods> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return goodsService.listByCategory(cid);
        } else {
            return list();
        }
    }

}
