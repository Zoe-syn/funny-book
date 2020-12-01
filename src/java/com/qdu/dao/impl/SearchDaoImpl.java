/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.SearchDao;
import com.qdu.entity.Merchandises;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Merchandises> getMerchandiseListByKeyworkd(String keyword){
        System.out.println(",......................................");
        System.out.println("%"+keyword+"%");
       
//       return   sessionFactory.getCurrentSession().createQuery("select  pname，pprice from Merchandises where pname like:pattern").setParameter("pattern", "%"+keyword+"%").list();
        return   sessionFactory.getCurrentSession().createQuery("from Merchandises where categoryName like:pattern").setParameter("pattern", "%"+keyword+"%").list();
           
    }
}
