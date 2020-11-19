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

    List getPurchaseOrderList();
    
    List getPurchaseOrderListByCid(String cid);

    Object addPurchaseOrder(PurchaseOrder order);

    void updatePurchaseOrder(PurchaseOrder order);

    void deletePurchaseOrder(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
}
