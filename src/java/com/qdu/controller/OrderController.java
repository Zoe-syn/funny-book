/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.ShoppingChe;
import com.qdu.entity.Merchandises;
import com.qdu.entity.PurchaseOrder;
import com.qdu.entity.Subscribers;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MerchandiseService;
import com.qdu.service.PurchaseOrderService;
import com.qdu.service.SubscriberInfoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private ShoppingCheService cartService;
    @Autowired
    private SubscriberInfoService userInfoService;
    @Autowired
    private MerchandiseService productService;
    
    List clist = new ArrayList();
    List olist = new ArrayList();
    List plist = new ArrayList(); 
    
    
    @PostMapping("/addOrder")
    public String insert(HttpSession session, HttpServletRequest req) {
        // purchaseOrderService
        String[] a = req.getParameterValues("getShoppingChe");
       
        BigDecimal total=new BigDecimal("0.0");
        for (String b : a) {
            PurchaseOrder order=new PurchaseOrder();
            ShoppingChe ca = cartService.getShoppingCheById(b);
            order.setPid(ca.getPid());
            BigDecimal price=ca.getCprice();
            int quantity=ca.getCquantity();
            BigDecimal j=price.multiply(new BigDecimal(quantity));
            order.setPprice(j);
            clist.add(ca);
            Subscribers u = (Subscribers) session.getAttribute("user");
            //List<PurchaseOrder> orderlist=purchaseOrderService.getPurchaseOrderListByCid(u.getUid());
            
            //session.setAttribute("orderListByCid",orderlist);
            
            order.setCid(u.getUid());
            order.setReceiverName(u.getUname());
            order.setPstatus("未支付");
            order.setBuyerAddress(userInfoService.getSubscriberInfoById(u.getUid()).getUaddress());
            order.setBuyerPhone(userInfoService.getSubscriberInfoById(u.getUid()).getUcontact());
            
            total=total.add(j);
            System.out.println("total-----------"+total);
            purchaseOrderService.addPurchaseOrder(order);
            olist.add(order);
            
            //根据pid查商品
//            Merchandises p=productService.getMerchandisesById(order.getPid());
//            plist.add(p);
//            session.setAttribute("plist", plist);
        }
       
            
        session.setAttribute("clist",clist);
        
        session.setAttribute("orderList",olist);
        
        session.setAttribute("total", total);
     
//        ShoppingChe cart = (ShoppingChe) session.getAttribute("cart");
        Iterator it = olist.iterator();
        while(it.hasNext()) {
            System.out.println("__________________----");
            System.out.println(it.next());
        }
        Iterator it2 = clist.iterator();
        while(it2.hasNext()) {
            System.out.println("++++++++++++++++++++++++----");
            System.out.println(it2.next());
        }
        
         for (String b : a) {
             cartService.deleteShoppingChe(b);
             System.out.println("删除成功！");
         }
//            TorderItem orderItem = (TorderItem) it.next();
//            String goods_id = orderItem.getGoods().getId();
//            int goods_quantity = orderItem.getGoods_quantity();
//        }
//        cart.getItems().clear();
//        session.setAttribute("cart", cart);
        return "order";
    }

     @PostMapping("/updateOrder")
      public String updateOrder(HttpSession session, HttpServletRequest req) {
          List<PurchaseOrder> orList=(List)session.getAttribute("orderList");
          for(PurchaseOrder porder:orList){
            porder.setPstatus("已支付");
            purchaseOrderService.updatePurchaseOrder(porder);
          }
          return "pay";
      }
   
}
