/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.SubscriberInfoDao;
import com.qdu.entity.SubscriberInfo;
import com.qdu.service.SubscriberInfoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class SubscriberInfoServiceImpl implements SubscriberInfoService {

    @Autowired
    private SubscriberInfoDao subscriberInfoDao;

    @Override
    public SubscriberInfo getSubscriberInfoById(String id) {

        return subscriberInfoDao.getOneById(id);
    }

    @Override
    public List getSubscriberInfoList() {
        return subscriberInfoDao.getAll();
    }
 

    public Object addSubscriberInfo(SubscriberInfo subscriberInfo) {
//        String OId = (String) subscriberInfo.setSubscriberInfoId1(orderCode.getOrderCode());
//        HttpSession session= sessionFactory.getCurrentSession();
//        subscriberInfoDao.insert(subscriberInfo);
        return subscriberInfoDao.insert(subscriberInfo);
    } 


    @Override
    public void updateSubscriberInfo(SubscriberInfo subscriberInfo) {

        subscriberInfoDao.update(subscriberInfo);
    }

    @Override
    public void deleteSubscriberInfo(String id) {

        subscriberInfoDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return subscriberInfoDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }
}
