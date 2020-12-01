/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.MerchandiseDao;
import com.qdu.entity.Merchandises;
import com.qdu.service.MerchandiseService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lenovo
 */
@Service
@Transactional
public class MerchandiseServiceImpl implements MerchandiseService {

    @Autowired
    private MerchandiseDao merchandiseDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Merchandises getMerchandisesById(String id) {

        return merchandiseDao.getOneById(id);
    }

    @Override
    public List getMerchandisesList() {
        return merchandiseDao.getAll();
    }

    @Override
    public List getMpbileMerchandisesList() {
        return merchandiseDao.getMobilephoneAll();
    }

    @Override
    public List getBookList() {
        return merchandiseDao.getBookAll();
    }

    @Override
    public List getDigitalList() {
        return merchandiseDao.getDigitalAll();
    }

    public Object addMerchandises(Merchandises merchandise) {
        return merchandiseDao.insert(merchandise);
    }

    @Override
    public void updateMerchandises(Merchandises merchandise) {

        merchandiseDao.update(merchandise);
    }

    @Override
    public void deleteMerchandises(String id) {

        merchandiseDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return merchandiseDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }
    
      @Override
    public List getMerchandiseListByPuid(String id) {
        return merchandiseDao.getAllByPuid(id);
    }

     @Override
    public String getPuidById(String id) {
        Merchandises a = merchandiseDao.getOneById(id);
        return a.getUid();
    }
}
