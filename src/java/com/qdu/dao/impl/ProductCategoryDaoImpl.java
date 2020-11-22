/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.ProductCategoryDao;
import com.qdu.entity.ProductCategory;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lenovo
 */
@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao{

     @Autowired
    private SessionFactory sessionFactory;
     
    @Override
    public List<ProductCategory> getCategoryName() {
       List list=sessionFactory.getCurrentSession().createCriteria(ProductCategory.class).list();
        return list;
    }
    
}
