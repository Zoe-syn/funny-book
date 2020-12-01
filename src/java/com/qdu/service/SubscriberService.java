/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Subscribers;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author lihexiao
 */
public interface SubscriberService {

    Subscribers getSubscriberById(String id);

    
//    Subscribers getSubscriberByName(String name);

    List getSubscriberList();

    Object addSubscriber(Subscribers subscriber);

    void updateSubscriber(Subscribers subscriber);

    void deleteSubscriber(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);

    public Subscribers validateLogin(String subscribername, String password);

     Subscribers getSubscriberByName(String name);
    
}
