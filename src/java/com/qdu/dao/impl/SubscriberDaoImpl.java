/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SubscriberDao;
import com.qdu.entity.Subscribers;
import com.qdu.id.uId;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lenovo
 */
@Repository
public class SubscriberDaoImpl implements SubscriberDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Subscribers subscriber) {
        subscriber.setUid(uId.getUIdCode());
        return sessionFactory.getCurrentSession().save(subscriber);
    }

    @Override
    public void update(Subscribers subscriber) {
        sessionFactory.getCurrentSession().update(subscriber);

    }

    @Override
    public void deleteById(String id) {
        Subscribers p = sessionFactory.getCurrentSession().get(Subscribers.class, id);
        sessionFactory.getCurrentSession().delete(p);

    }

    @Override
    public Subscribers getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Subscribers.class, id);

    }

    @Override
    public Subscribers getOneByName(String uname) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Subscribers where uname=:name");
        query.setParameter("name", uname);
        Subscribers subscriber=(Subscribers)query.uniqueResult();
//        System.out.println(subscriber.getUanswer());
        return subscriber;

    }

    @Override
    public List<Subscribers> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Subscribers.class).list();

    }

    @Override
    public List<Subscribers> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Subscribers.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();

    }

}
