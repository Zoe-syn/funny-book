package com.qdu.service;

import com.qdu.entity.Subscribers;

public interface SubscriberServiceDemo {

    int getSubscriberByName(String name);
    
    void insertOne(Subscribers u);
}
