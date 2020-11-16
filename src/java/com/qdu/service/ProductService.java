/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Products;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface ProductService {
    Products getProductsById(String id);

    List getProductsList();
    
    List getMpbileProductsList();
    
    List getBookList();
    
    List getDigitalList();

    Object addProducts(Products product);

    void updateProducts(Products product);

    void deleteProducts(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
       String getPuidById(String id);   
          List getProductListByPuid(String id);
}
