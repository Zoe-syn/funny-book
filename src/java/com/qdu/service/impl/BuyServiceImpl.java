/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.BuyDao;
import com.qdu.entity.Buy;
import com.qdu.service.BuyService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyDao buyDao;

    @Override
    public Buy getBuyById(String id) {

        return buyDao.getOneById(id);
    }

    @Override
    public List getBuyList() {
        return buyDao.getAll();
    }
 

    public Object addBuy(Buy buy) {

        return buyDao.insert(buy);
    } 


    @Override
    public void updateBuy(Buy buy) {

        buyDao.update(buy);
    }

    @Override
    public void deleteBuy(String id) {

        buyDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return buyDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override
    public void deleteBuyBook(String bookid) {
         buyDao.deleteById(bookid);
    }

    @Override
    public void updateBuyBook(Buy buybooks) {
          buyDao.update(buybooks);
    }
}
