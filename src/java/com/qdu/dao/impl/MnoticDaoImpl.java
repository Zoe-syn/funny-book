/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.MnoticDao;
import com.qdu.entity.Notice;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 花花hy
 */
@Repository
public class MnoticDaoImpl implements MnoticDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Notice> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Notice").list();
    }

    @Override
    public void update(Notice notice) {
         sessionFactory.getCurrentSession().update(notice);
    }

    @Override
    public void deleteById(String id) {
        Notice n=sessionFactory.getCurrentSession().load(Notice.class, id);
        sessionFactory.getCurrentSession().delete(n);
    }

    @Override
    public Notice getOneById(String id) {
         return sessionFactory.getCurrentSession().get(Notice.class, id);
    }
    
}
