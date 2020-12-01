/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SelectDao;
import com.qdu.entity.Merchandises;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SelectDaoImpl  implements SelectDao{
     
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Merchandises> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Merchandises.class).list();
    }

    @Override
    public List<Merchandises> getAllBook() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
}
