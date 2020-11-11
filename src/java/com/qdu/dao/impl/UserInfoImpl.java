/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.UserInfoDao;
import com.qdu.entity.UserInfo;
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
public class UserInfoImpl implements UserInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(UserInfo userInfo) { 

        return sessionFactory.getCurrentSession().save(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        sessionFactory.getCurrentSession().update(userInfo);
    }

    @Override
    public void deleteById(String id) {
        UserInfo p = sessionFactory.getCurrentSession().get(UserInfo.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public UserInfo getOneById(String id) {
        return sessionFactory.getCurrentSession().get(UserInfo.class, id);
    }

    @Override
    public List<UserInfo> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserInfo.class).list();
    }

    @Override
    public List<UserInfo> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(UserInfo.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }

}
