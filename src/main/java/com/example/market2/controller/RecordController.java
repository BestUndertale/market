package com.example.market2.controller;

import com.example.market2.entity.Record;
import com.example.market2.entity.User;
import com.example.market2.result.Result;
import com.example.market2.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RecordController {
    RecordService recordService;
    @Autowired
    public void setRecordService(RecordService recordService){
        this.recordService = recordService;
    }

    @CrossOrigin
    @PostMapping(value = "api/buy")
    @ResponseBody
    public Result Register(@RequestBody Record record){
        String name = record.getName();
        name = HtmlUtils.htmlEscape(name);
        recordService.add(record);
        return new Result(200);
    }
}
