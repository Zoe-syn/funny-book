/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.entity.ShoppingChe;
import com.qdu.entity.Subscribers;
import com.qdu.id.shoppingCheId;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qdu.dao.ShoppingCheDao;

/**
 *
 * @author lihexiao
 */
@Repository
public class ShoppingCheDaoImpl implements ShoppingCheDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(ShoppingChe shoppingChe) {
        shoppingChe.setShoppingCheId(shoppingCheId.getShoppingCheIdCode());
        Date date = new Date();// 获取当前时间 
        shoppingChe.setCtime(date);
        shoppingChe.setCquantity(1);
        return sessionFactory.getCurrentSession().save(shoppingChe);
    }

    @Override
    public void update(ShoppingChe shoppingChe) {
        System.out.println("前："+shoppingChe.getCquantity());
        sessionFactory.getCurrentSession().update(shoppingChe);
        System.out.println("后============================："+shoppingChe.getCquantity());
    }

    @Override
    public void deleteById(String id) {
        System.out.println("..............................");
        System.out.println(id);
        ShoppingChe p = sessionFactory.getCurrentSession().get(ShoppingChe.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public ShoppingChe getOneById(String id) {
        return sessionFactory.getCurrentSession().get(ShoppingChe.class, id);
    }

    @Override
    public List<ShoppingChe> getAll(String uid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ShoppingChe where UID=:uid");
        query.setParameter("uid", uid);
        List<ShoppingChe> list = query.list();
        return list;
    }

    @Override
    public List<ShoppingChe> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(ShoppingChe.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }

    @Override 
    public ShoppingChe getOneByPId(String pid,String uid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ShoppingChe where pid=:pid and uid=:uid");
        query.setParameter("pid", pid);
        query.setParameter("uid", uid);
        ShoppingChe shoppingChe=(ShoppingChe)query.uniqueResult();
        return shoppingChe;
    }

    @Override
    public List<ShoppingChe> getAllBook(String bookid) {
          Query query = sessionFactory.getCurrentSession().createQuery("from ShoppingChe where BookID=:bookid");
         query.setParameter("bookid", bookid);
        List<ShoppingChe> bookslist = query.list();
        return bookslist;
    }

}
