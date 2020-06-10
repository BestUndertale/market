package com.example.market2.dao;

import com.example.market2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//使用了JPA中的JpaRepository<Goods,Integer>，只需使用对应方法，不用编写sql语句
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);//通过用户名寻找
    User getByUsernameAndPassword(String username, String password);//获取用户名和密码
}
