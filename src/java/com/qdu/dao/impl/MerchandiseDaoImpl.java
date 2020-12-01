/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.MerchandiseDao;
import com.qdu.entity.Merchandises;
import com.qdu.id.merchandisesId;
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
public class MerchandiseDaoImpl implements MerchandiseDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Merchandises merchandise) { 
        merchandise.setPid(merchandisesId.getMerchandisesIdCode());
        return sessionFactory.getCurrentSession().save(merchandise);
    }

    @Override
    public void update(Merchandises merchandise) {
        sessionFactory.getCurrentSession().update(merchandise);
    }

    @Override
    public void deleteById(String id) {
        Merchandises p = sessionFactory.getCurrentSession().get(Merchandises.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public Merchandises getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Merchandises.class, id);
    }

    @Override
    public List<Merchandises> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Merchandises.class).list();
    }
    
     @Override
    public List<Merchandises> getMobilephoneAll() {
        return sessionFactory.getCurrentSession().createQuery("from Merchandises where categoryName='心理'").setFirstResult(0).setMaxResults(4).list();
    }
    
     @Override
    public List<Merchandises> getBookAll() {
//        return sessionFactory.getCurrentSession().createSQLQuery("select top 4 *  from Merchandises where CategoryName='书'").list();
           return sessionFactory.getCurrentSession().createQuery("from Merchandises where categoryName='科幻'").setFirstResult(0).setMaxResults(4).list();
    }
    @Override
    public List<Merchandises> getDigitalAll() {
//        return sessionFactory.getCurrentSession().createSQLQuery("select top 4 * from Merchandises where CategoryName='数码'").list();
           return sessionFactory.getCurrentSession().createQuery("from Merchandises where categoryName='文学'").setFirstResult(0).setMaxResults(4).list();
    }

    @Override
    public List<Merchandises> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Merchandises.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }
 @Override
    public List<Merchandises> getAllByPuid(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Merchandises where uid=:id");
        query.setParameter("id", id);
        return query.list();
    }

}

