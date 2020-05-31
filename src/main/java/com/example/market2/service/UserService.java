package com.example.market2.service;

import com.example.market2.dao.UserDao;
import com.example.market2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserDao userdao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userdao = userDao;
    }
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    public User get(String username,String password){
        return userdao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userdao.save(user);
    }
}
