/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.CartDao;
import com.qdu.entity.Cart;
import com.qdu.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(String id) {
       return cartDao.getOneById(id);
    }

    @Override
    public List getCartList(String uid) {
        return cartDao.getAll(uid);
    }

    @Override
    public Object addCart(Cart cart) {
        return cartDao.insert(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.update(cart);
    }

    @Override
    public void deleteCart(String id) {
        cartDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
       return cartDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override 
    public Cart getCartByPId(String pid,String uid) {
        return cartDao.getOneByPId(pid,uid);
    }

}
