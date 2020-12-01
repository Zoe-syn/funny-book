package com.qdu.service.impl;

import com.qdu.dao.SubscriberDaoDemo;
import com.qdu.entity.Subscribers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qdu.service.SubscriberServiceDemo;

@Service
public class SubscriberServiceImplDemo implements SubscriberServiceDemo{

    @Autowired
    SubscriberDaoDemo subscriberDaoDemo;
    
    @Override
    public int getSubscriberByName(String name) {
        return subscriberDaoDemo.getSubscriberByName(name);
    }

    @Override
    public void insertOne(Subscribers u) {
        subscriberDaoDemo.insertOne(u);
    }
    
}
