/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.SubscriberDao;
import com.qdu.entity.Subscribers;
import com.qdu.service.SubscriberService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberDao subscriberDao;

    @Override 
    public Subscribers getSubscriberById(String id) {
        return subscriberDao.getOneById(id);
    }

    @Override
    public Subscribers getSubscriberByName(String name) {
        return subscriberDao.getOneByName(name);
    }
    

    @Override
    public List getSubscriberList() {
        return subscriberDao.getAll();
    }

    @Override
    public Object addSubscriber(Subscribers subscriber) {
        return subscriberDao.insert(subscriber);
    }

    @Override
    public void updateSubscriber(Subscribers subscriber) {
        subscriberDao.update(subscriber);
    }

    @Override
    public void deleteSubscriber(String id) {
        subscriberDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return subscriberDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override
    public Subscribers validateLogin(String uname, String upwd) {
        Subscribers subscriber =  subscriberDao.getOneByName(uname);
        if (null != subscriber && upwd.equals(subscriber.getUpwd())) {
            return subscriber;
        }
        return null;
    }

}
