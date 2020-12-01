/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Buy;
import java.util.List;
import javax.servlet.http.HttpSession;


public interface BuyBookDao {
    
     Object insert(Buy buybook);
     
     void update(Buy buybook);

    void deleteByBookId(String bookid);

    void deleteByBookName(String bookname);
 
    Buy getOneByBookId(String bookid);

    Buy getOneByBookName(String bookname);
  
    List<Buy> getAllBook();


    
    
}
    

