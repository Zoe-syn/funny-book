package com.qdu.service;

import com.qdu.entity.Users;

public interface UserServiceDemo {

    int getUserByName(String name);
    
    void insertOne(Users u);
}
