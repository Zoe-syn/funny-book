/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.PurchaseOrderDao;
import com.qdu.entity.PurchaseOrder;
import com.qdu.service.PurchaseOrderService;
import com.qdu.service.PurchaseOrderService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;


    @Override
    public PurchaseOrder getPurchaseOrderById(String id) {

        return purchaseOrderDao.getOneById(id);
    }

    @Override
    public List getPurchaseOrderList() {
        return purchaseOrderDao.getAll();
    }

    
    @Override
    public List getPurchaseOrderListByCid(String cid) {
        return purchaseOrderDao.getAllByCid(cid);
    }
    
    @Override
    public Object addPurchaseOrder(PurchaseOrder purchaseOrder) {

       
        return purchaseOrderDao.insert(purchaseOrder);
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {

        purchaseOrderDao.update(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(String id) {

        purchaseOrderDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return purchaseOrderDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

}
