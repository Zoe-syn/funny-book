/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.PurchaseOrderDao;
import com.qdu.entity.PurchaseOrder;
import com.qdu.id.cartId;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lihexiao
 */
@Repository
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(PurchaseOrder order) {
        order.setOrderId(cartId.getCartIdCode());
        Date date = new Date();// 获取当前时间 
        order.setOrderDate(date);
        return sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void update(PurchaseOrder order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteById(String id) {
        PurchaseOrder p = sessionFactory.getCurrentSession().get(PurchaseOrder.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public PurchaseOrder getOneById(String id) {
        return sessionFactory.getCurrentSession().get(PurchaseOrder.class, id);
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(PurchaseOrder.class).list();
    }
    
    @Override
    public List<PurchaseOrder> getAllByCid(String cid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PurchaseOrder where cid=:uid");
        query.setParameter("uid", cid);
        List<PurchaseOrder> list = query.list();
        return list;
    }

    @Override
    public List<PurchaseOrder> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(PurchaseOrder.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();

    }

}
