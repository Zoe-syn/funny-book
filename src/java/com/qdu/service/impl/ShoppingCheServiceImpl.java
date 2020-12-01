/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.entity.ShoppingChe;
import com.qdu.service.ShoppingCheService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qdu.dao.ShoppingCheDao;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class ShoppingCheServiceImpl implements ShoppingCheService {

    @Autowired
    private ShoppingCheDao cartDao;

    @Override
    public ShoppingChe getShoppingCheById(String id) {
       return cartDao.getOneById(id);
    }

    @Override
    public List getShoppingCheList(String uid) {
        return cartDao.getAll(uid);
    }

    @Override
    public Object addShoppingChe(ShoppingChe cart) {
        return cartDao.insert(cart);
    }

    @Override
    public void updateShoppingChe(ShoppingChe cart) {
        cartDao.update(cart);
    }

    @Override
    public void deleteShoppingChe(String id) {
        cartDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
       return cartDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override 
    public ShoppingChe getShoppingCheByPId(String pid,String uid) {
        return cartDao.getOneByPId(pid,uid);
    }

    @Override
    public void updateShoppingChe(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
