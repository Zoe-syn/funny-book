/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.ProductDao;
import com.qdu.entity.Products;
import com.qdu.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Products getProductsById(String id) {

        return productDao.getOneById(id);
    }

    @Override
    public List getProductsList() {
        return productDao.getAll();
    }

    @Override
    public List getMpbileProductsList() {
        return productDao.getMobilephoneAll();
    }

    @Override
    public List getBookList() {
        return productDao.getBookAll();
    }

    @Override
    public List getDigitalList() {
        return productDao.getDigitalAll();
    }

    public Object addProducts(Products product) {
        return productDao.insert(product);
    }

    @Override
    public void updateProducts(Products product) {

        productDao.update(product);
    }

    @Override
    public void deleteProducts(String id) {

        productDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return productDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }
    
      @Override
    public List getProductListByPuid(String id) {
        return productDao.getAllByPuid(id);
    }

     @Override
    public String getPuidById(String id) {
        Products a = productDao.getOneById(id);
        return a.getUid();
    }
}
