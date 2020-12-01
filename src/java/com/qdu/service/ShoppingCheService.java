/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.ShoppingChe;
import java.util.List;

/**
 *
 * @author lihexiao
 */
public interface ShoppingCheService {

    ShoppingChe getShoppingCheById(String id);
    
    ShoppingChe getShoppingCheByPId(String pid,String uid);

    List getShoppingCheList(String uid);

    Object addShoppingChe(ShoppingChe cart);

    void updateShoppingChe(ShoppingChe cart);

    void deleteShoppingChe(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);

    public void updateShoppingChe(String id);

}
