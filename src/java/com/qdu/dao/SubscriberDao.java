/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Subscribers;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface SubscriberDao {

    Object insert(Subscribers subscriber);

    void update(Subscribers subscriber);

    void deleteById(String id);

    Subscribers getOneById(String id);
    
    Subscribers getOneByName(String name);

    List<Subscribers> getAll();

    List<Subscribers> getListByPageNumberAndSize(int pageNumber, int pageSize);

    

}
