/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.ShaixuanDao;
import com.qdu.entity.Products;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public class ShaixuanDaoImpl  implements ShaixuanDao{
     
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Products.class).list();
    }
     
}
