/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.PurchaseOrder;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lihexiao
 */
public interface PurchaseOrderService {
    PurchaseOrder getPurchaseOrderById(String id);
    PurchaseOrder getPurchaseBookOrderById(String orderid);
    List getPurchaseBookOrderList();
     List getPurchaseBookOrderListByCid(String bid);
    List getPurchaseOrderList();
    
    List getPurchaseOrderListByCid(String cid);

    Object addPurchaseOrder(PurchaseOrder order);
     Object addPurchaseBookOrder(PurchaseOrder bookorder);
    void updatePurchaseOrder(PurchaseOrder order);
    void updatePurchaseBookOrder(PurchaseOrder bookorder);
    void deletePurchaseOrder(String id);
     void deletePurchaseBookOrder(String bookid);
    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
}
