/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.DiscussDao;
import com.qdu.entity.CommentUserId;
import com.qdu.entity.Discuss;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DiscussDaoImpl implements DiscussDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Discuss pcomment) {
        sessionFactory.getCurrentSession().save(pcomment);
    }

    @Override
    public void update(Discuss pcomment) {
        sessionFactory.getCurrentSession().update(pcomment);
    }

    @Override
    public List<Discuss> getDiscussByPid(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Discuss where pid=:id");
        query.setParameter("id", id);
        List<Discuss> l = query.list();
        return l;
    }

    @Override
    public void updateLikeNum(CommentUserId id) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Discuss set clike=clike+1 where pid=:pid and uid=:uid");
        query.setParameter("pid", id.getPid());
        query.setParameter("uid", id.getUid());
        query.executeUpdate();
    }

    @Override
    public Discuss getDiscussById(CommentUserId id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Discuss where pid=:pid and uid=:uid");
        query.setParameter("pid", id.getPid());
        query.setParameter("uid", id.getUid());
        Discuss pcomment = (Discuss)query.uniqueResult();
        return pcomment;
    }

    @Override
    public void insertPinglun(Discuss bookcomment) {
         sessionFactory.getCurrentSession().save(bookcomment);
    }

    @Override
    public void updatePinglun(Discuss bookcomment) {
        sessionFactory.getCurrentSession().update(bookcomment);
    }

    @Override
    public List<Discuss> getDiscussByBookid(String bookid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Discuss where bookid=:id");
        query.setParameter("id", bookid);
        List<Discuss> bookpl = query.list();
        return bookpl;
    }

    @Override
    public Discuss getDiscussByBookId(CommentUserId userbookid) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Discuss getDiscussByName(CommentUserId uname) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    
    
    
}
