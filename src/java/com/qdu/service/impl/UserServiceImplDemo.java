package com.qdu.service.impl;

import com.qdu.dao.UserDaoDemo;
import com.qdu.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.service.UserServiceDemo;

@Service
public class UserServiceImplDemo implements UserServiceDemo{

    @Autowired
    UserDaoDemo userDaoDemo;
    
    @Override
    public int getUserByName(String name) {
        return userDaoDemo.getUserByName(name);
    }

    @Override
    public void insertOne(Users u) {
        userDaoDemo.insertOne(u);
    }
    
}
