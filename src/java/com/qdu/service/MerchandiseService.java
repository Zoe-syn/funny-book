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
 * @author lenovo
 */
public interface MerchandiseService {
    Merchandises getMerchandisesById(String id);

    List getMerchandisesList();
    
    List getMpbileMerchandisesList();
    
    List getBookList();
    
    List getDigitalList();

    Object addMerchandises(Merchandises merchandise);

    void updateMerchandises(Merchandises merchandise);

    void deleteMerchandises(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
       String getPuidById(String id);   
          List getMerchandiseListByPuid(String id);
}
