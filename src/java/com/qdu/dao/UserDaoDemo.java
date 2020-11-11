
package com.qdu.dao;

import com.qdu.entity.Users;

public interface UserDaoDemo {
    //根据名字查询一个用户
    int getUserByName(String name);
    //添加一个用户
    void insertOne(Users u);
}
