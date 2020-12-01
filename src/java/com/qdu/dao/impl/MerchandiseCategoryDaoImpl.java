/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.MerchandiseCategoryDao;
import com.qdu.entity.MerchandiseCategory;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lenovo
 */
@Repository
public class MerchandiseCategoryDaoImpl implements MerchandiseCategoryDao{

     @Autowired
    private SessionFactory sessionFactory;
     
    @Override
    public List<MerchandiseCategory> getCategoryName() {
       List list=sessionFactory.getCurrentSession().createCriteria(MerchandiseCategory.class).list();
        return list;
    }
    
}
