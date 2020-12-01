/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Merchandises;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface SearchService {
    
    List getSearchProductList(String keyword);
    List getSearchBookList(String keyword);
    public List<Merchandises> getSearchMerchandiseList(String keyword);

   
    
}
