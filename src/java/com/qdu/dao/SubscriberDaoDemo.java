
package com.qdu.dao;

import com.qdu.entity.Subscribers;

public interface SubscriberDaoDemo {
    //根据名字查询一个用户
    int getSubscriberByName(String name);
    //添加一个用户
    void insertOne(Subscribers u);
}
