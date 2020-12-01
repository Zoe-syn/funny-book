/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.RecommentDao;
import com.qdu.entity.Recomment;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RecommentDaoImpl implements RecommentDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Object insert(Recomment recomment) {
        return sessionFactory.getCurrentSession().save(recomment);
    }

    @Override
    public void update(Recomment recomment) {
        sessionFactory.getCurrentSession().update(recomment);
    }

    @Override
    public void deleteById(int id) {
        Recomment p = sessionFactory.getCurrentSession().load(Recomment.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public Recomment getOneById(int id) {
        return sessionFactory.getCurrentSession().get(Recomment.class, id);
    }

    @Override
    public List<Recomment> getAllByPid(String pid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Recomment where Pid=:id");
        query.setParameter("id", pid);
        return query.list();
    }

    @Override
    public List<Recomment> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createQuery("from Recomment")
                .setFirstResult((pageNumber-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public Object insertBookComment(Recomment bookrecomment) {
        return sessionFactory.getCurrentSession().save(bookrecomment);
    }

    @Override
    public void updateBookComment(Recomment bookrecomment) {
        sessionFactory.getCurrentSession().update(bookrecomment);
    }
    
}
