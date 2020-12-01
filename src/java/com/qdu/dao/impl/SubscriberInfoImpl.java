/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SubscriberInfoDao;
import com.qdu.entity.SubscriberInfo;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lihexiao
 */
@Repository
public class SubscriberInfoImpl implements SubscriberInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(SubscriberInfo subscriberInfo) { 

        return sessionFactory.getCurrentSession().save(subscriberInfo);
    }

    @Override
    public void update(SubscriberInfo subscriberInfo) {
        sessionFactory.getCurrentSession().update(subscriberInfo);
    }

    @Override
    public void deleteById(String id) {
        SubscriberInfo p = sessionFactory.getCurrentSession().get(SubscriberInfo.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public SubscriberInfo getOneById(String id) {
        return sessionFactory.getCurrentSession().get(SubscriberInfo.class, id);
    }

    @Override
    public List<SubscriberInfo> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(SubscriberInfo.class).list();
    }

    @Override
    public List<SubscriberInfo> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(SubscriberInfo.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }

    @Override
    public List<SubscriberInfo> getAllBook() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
