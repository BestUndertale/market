package com.example.market2.service;

import com.example.market2.dao.UserDao;
import com.example.market2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //注入实例
    UserDao userdao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userdao = userDao;
    }

    //判断用户名是否存在
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    //通过用户名寻找用户
    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    //获取数据库中用户名和密码
    public User get(String username,String password){
        return userdao.getByUsernameAndPassword(username,password);
    }

    //添加用户
    public void add(User user){
        userdao.save(user);
    }
}
