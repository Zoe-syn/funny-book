/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.SousuoDao;
import com.qdu.service.SousuoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class SousuoServiceImpl implements SousuoService {
    
    @Autowired
    private SousuoDao sousuoDao;
    


    @Override
    public List getSearchProductList(String keyword) {
      
          return  sousuoDao.getProductListByKeyworkd(keyword);
    }

 
    
}
