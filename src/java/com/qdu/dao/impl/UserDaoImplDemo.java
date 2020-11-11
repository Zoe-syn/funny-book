package com.qdu.dao.impl;

import com.qdu.dao.UserDaoDemo;
import com.qdu.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplDemo implements UserDaoDemo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int getUserByName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Users where uname=:name");
        query.setParameter("name", name);
        Users user=(Users)query.uniqueResult();
        return user!=null?1:0;
    }

    @Override
    public void insertOne(Users u) {
        sessionFactory.getCurrentSession().save(u);
    }

}
