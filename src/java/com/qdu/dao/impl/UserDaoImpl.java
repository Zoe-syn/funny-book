/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.UserDao;
import com.qdu.entity.Users;
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
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Users user) {
        user.setUid(uId.getUIdCode());
        return sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(Users user) {
        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public void deleteById(String id) {
        Users p = sessionFactory.getCurrentSession().get(Users.class, id);
        sessionFactory.getCurrentSession().delete(p);

    }

    @Override
    public Users getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Users.class, id);

    }

    @Override
    public Users getOneByName(String uname) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Users where uname=:name");
        query.setParameter("name", uname);
        Users user=(Users)query.uniqueResult();
//        System.out.println(user.getUanswer());
        return user;

    }

    @Override
    public List<Users> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();

    }

    @Override
    public List<Users> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Users.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();

    }

}
