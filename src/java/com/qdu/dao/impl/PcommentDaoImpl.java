/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.PcommentDao;
import com.qdu.entity.CommentUserId;
import com.qdu.entity.Pcomment;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Echo
 */
@Repository
public class PcommentDaoImpl implements PcommentDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Pcomment pcomment) {
        sessionFactory.getCurrentSession().save(pcomment);
    }

    @Override
    public void update(Pcomment pcomment) {
        sessionFactory.getCurrentSession().update(pcomment);
    }

    @Override
    public List<Pcomment> getPcommentByPid(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Pcomment where pid=:id");
        query.setParameter("id", id);
        List<Pcomment> l = query.list();
        return l;
    }

    @Override
    public void updateLikeNum(CommentUserId id) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Pcomment set clike=clike+1 where pid=:pid and uid=:uid");
        query.setParameter("pid", id.getPid());
        query.setParameter("uid", id.getUid());
        query.executeUpdate();
    }

    @Override
    public Pcomment getPcommentById(CommentUserId id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Pcomment where pid=:pid and uid=:uid");
        query.setParameter("pid", id.getPid());
        query.setParameter("uid", id.getUid());
        Pcomment pcomment = (Pcomment)query.uniqueResult();
        return pcomment;
    }


    
    
    
}
