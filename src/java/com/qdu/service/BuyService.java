/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Buy;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lihexiao
 */
public interface BuyService {
    Buy getBuyById(String id);

    List getBuyList();

    Object addBuy(Buy buy);

    void updateBuy(Buy buy);

    void deleteBuy(String id);
   

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
     void deleteBuyBook(String bookid);
     void updateBuyBook(Buy buybooks);
}
