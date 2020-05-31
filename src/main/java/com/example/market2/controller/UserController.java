package com.example.market2.controller;


import com.example.market2.entity.Goods;
import com.example.market2.entity.User;
import com.example.market2.result.Result;
import com.example.market2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        String password = requestUser.getPassword();
        password = HtmlUtils.htmlEscape(password);

        User user = userService.get(username,requestUser.getPassword());
        if(null == user){
            return new Result(400);
        }
        else{
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result Register(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        String password = requestUser.getPassword();
        password = HtmlUtils.htmlEscape(password);

        userService.add(requestUser);
        return new Result(200);
    }
}

