/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.SearchDao;
import com.qdu.service.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class SearchServiceImpl implements SearchService {
    
    @Autowired
    private SearchDao searchDao;
    


    public List getSearchMerchandiseList(String keyword) {
      
          return  searchDao.getMerchandiseListByKeyworkd(keyword);
    }

    @Override
    public List getSearchProductList(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List getSearchBookList(String keyword) {
       throw new UnsupportedOperationException("Not supported yet."); 
    }

 
    
}
