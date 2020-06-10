package com.example.market2.controller;


import com.example.market2.entity.User;
import com.example.market2.result.Result;
import com.example.market2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;



@Controller
public class UserController {

    //注入实例
    UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin//实现跨域
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {//登录，查询是否有此用户
        // 对 html 标签进行转义，防止 XSS 攻击
        //获取用户名
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        //根据用户名查询密码
        User user = userService.get(username,requestUser.getPassword());
        if(null == user){
            return new Result(400);//无此用户，失败
        }
        else{
            return new Result(200);//成功
        }
    }

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result Register(@RequestBody User requestUser){//添加用户
        //获取用户名
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        //获取密码
        String password = requestUser.getPassword();
        password = HtmlUtils.htmlEscape(password);

        userService.add(requestUser);//添加
        return new Result(200);
    }
}

