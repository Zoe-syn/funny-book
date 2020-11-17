/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.MwelcomCountDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author 花花hy
 */
@Repository("MwelcomCountDao")
public class MwelcomCountDaoImpl implements MwelcomCountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long getyhs() {
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("select count(*) from Users");
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    public Long getsps() {
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("select count(*) from Products");
        Long count = (Long) query.uniqueResult();
        return count;
    }

    @Override
    public Long getdds() {
        Query query = (Query) sessionFactory.getCurrentSession().createQuery("select count(*) from PurchaseOrder");
        Long count = (Long) query.uniqueResult();
        return count;
    }
 

}
