/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.ProductDao;
import com.qdu.entity.Products;
import com.qdu.id.productsId;
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
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Products product) { 
        product.setPid(productsId.getProductsIdCode());
        return sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void update(Products product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void deleteById(String id) {
        Products p = sessionFactory.getCurrentSession().get(Products.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public Products getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Products.class, id);
    }

    @Override
    public List<Products> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Products.class).list();
    }
    
     @Override
    public List<Products> getMobilephoneAll() {
        return sessionFactory.getCurrentSession().createQuery("from Products where categoryName='心理'").setFirstResult(0).setMaxResults(4).list();
    }
    
     @Override
    public List<Products> getBookAll() {
//        return sessionFactory.getCurrentSession().createSQLQuery("select top 4 *  from Products where CategoryName='书'").list();
           return sessionFactory.getCurrentSession().createQuery("from Products where categoryName='科幻'").setFirstResult(0).setMaxResults(4).list();
    }
    @Override
    public List<Products> getDigitalAll() {
//        return sessionFactory.getCurrentSession().createSQLQuery("select top 4 * from Products where CategoryName='数码'").list();
           return sessionFactory.getCurrentSession().createQuery("from Products where categoryName='文学'").setFirstResult(0).setMaxResults(4).list();
    }

    @Override
    public List<Products> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Products.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }
 @Override
    public List<Products> getAllByPuid(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Products where uid=:id");
        query.setParameter("id", id);
        return query.list();
    }

}

