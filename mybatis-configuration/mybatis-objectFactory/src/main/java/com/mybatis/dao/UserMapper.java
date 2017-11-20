package com.mybatis.dao;

import com.mybatis.model.User;

public interface UserMapper {

    User selectUserById(Integer id);
    
    int insertUser(User user);
}