/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Cart;
import java.util.List;

/**
 *
 * @author lihexiao
 */
public interface CartService {

    Cart getCartById(String id);
    
    Cart getCartByPId(String pid,String uid);

    List getCartList(String uid);

    Object addCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);

}
