/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SousuoDao;
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
public class SousuoDaoImpl implements SousuoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Products> getProductListByKeyworkd(String keyword){
        System.out.println(",......................................");
        System.out.println("%"+keyword+"%");
       
//       return   sessionFactory.getCurrentSession().createQuery("select  pname，pprice from Products where pname like:pattern").setParameter("pattern", "%"+keyword+"%").list();
        return   sessionFactory.getCurrentSession().createQuery("from Products where categoryName like:pattern").setParameter("pattern", "%"+keyword+"%").list();
           
    }
}
