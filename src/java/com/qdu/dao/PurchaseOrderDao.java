/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.PurchaseOrder;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lihexiao
 */
public interface PurchaseOrderDao {
     Object insert(PurchaseOrder order);

         Object insertBookOrder(PurchaseOrder bookorder);
     
    //传入一个包含更新后的产品信息的Product对象，更新产品信息到数据库
    void update(PurchaseOrder order);
    
    

 
    void updateBookOrder(PurchaseOrder bookorder);

    //根据产品编号删除单个产品
    void deleteById(String id);

     void deleteByBookId(String Bookid);
     
    void deleteBybookName(String bookname);
    
    //根据产品编号查询单个产品
    PurchaseOrder getOneById(String id);
    

    PurchaseOrder getOneByBookName(String bookname);
    
     PurchaseOrder getOneByBookId(String bookid);

    //获取所有产品的列表
    List<PurchaseOrder> getAll();
    
    List<PurchaseOrder> getAllBook();
    
    List<PurchaseOrder> getAllByCid(String cid);
     

   
    List<PurchaseOrder> getAllBookOrder();
    
     List<PurchaseOrder> getListByPageNumberAndSize(int pageNumber, int pageSize);

}
    

