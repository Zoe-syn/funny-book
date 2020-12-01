package com.qdu.dao.impl;

import com.qdu.dao.SubscriberDaoDemo;
import com.qdu.entity.Subscribers;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriberDaoImplDemo implements SubscriberDaoDemo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int getSubscriberByName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Subscribers where uname=:name");
        query.setParameter("name", name);
        Subscribers subscriber=(Subscribers)query.uniqueResult();
        return subscriber!=null?1:0;
    }

    @Override
    public void insertOne(Subscribers u) {
        sessionFactory.getCurrentSession().save(u);
    }

}
