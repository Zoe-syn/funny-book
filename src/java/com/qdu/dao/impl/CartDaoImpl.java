/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao.impl;

import com.qdu.dao.CartDao;
import com.qdu.entity.Cart;
import com.qdu.entity.Users;
import com.qdu.id.cartId;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lihexiao
 */
@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object insert(Cart cart) {
        cart.setCartId(cartId.getCartIdCode());
        Date date = new Date();// 获取当前时间 
        cart.setCtime(date);
        cart.setCquantity(1);
        return sessionFactory.getCurrentSession().save(cart);
    }

    @Override
    public void update(Cart cart) {
        System.out.println("前："+cart.getCquantity());
        sessionFactory.getCurrentSession().update(cart);
        System.out.println("后============================："+cart.getCquantity());
    }

    @Override
    public void deleteById(String id) {
        System.out.println("..............................");
        System.out.println(id);
        Cart p = sessionFactory.getCurrentSession().get(Cart.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public Cart getOneById(String id) {
        return sessionFactory.getCurrentSession().get(Cart.class, id);
    }

    @Override
    public List<Cart> getAll(String uid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cart where UID=:uid");
        query.setParameter("uid", uid);
        List<Cart> list = query.list();
        return list;
    }

    @Override
    public List<Cart> getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class)
                .setFirstResult((pageNumber - 1) * pageSize) //设置获取的当前页第一条记录的索引
                .setMaxResults(pageSize) //设置当前页获取的记录条数
                .list();
    }

    @Override 
    public Cart getOneByPId(String pid,String uid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cart where pid=:pid and uid=:uid");
        query.setParameter("pid", pid);
        query.setParameter("uid", uid);
        Cart cart=(Cart)query.uniqueResult();
        return cart;
    }

}
