/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.BuyDao;
import com.qdu.entity.Buy;
import com.qdu.id.buyId;
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
public class BuyDaoImpl implements BuyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Buy buy) { 

        buy.setBuyId(buyId.getBuyIdCode());

        Date date = new Date();// 获取当前时间 
        buy.setBtime(date);

        return sessionFactory.getCurrentSession().save(buy);
    }

    @Override
    public void update(Buy buy) {
        sessionFactory.getCurrentSession().update(buy);
    }

    @Override
    public void deleteById(String id) {
        Buy p = sessionFactory.getCurrentSession().get(Buy.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public Buy getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Buy.class, id);
    }

    @Override
    public List<Buy> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Buy.class).list();
    }

    @Override
    public List<Buy> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Buy.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }

    @Override
    public void deleteByName(String bookname) {
          Buy book = sessionFactory.getCurrentSession().get(Buy.class, bookname);
          sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public Buy getOneByName(String bookname) {
       return sessionFactory.getCurrentSession().get(Buy.class, bookname);
    }

}
