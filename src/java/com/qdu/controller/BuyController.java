   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.dao.BuyDao;
import com.qdu.entity.Buy;
import com.qdu.entity.Notice;
import com.qdu.entity.Merchandises;
import com.qdu.service.BuyService;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MnoticService;
import com.qdu.service.MerchandiseService;
import com.qdu.service.SubscriberService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lihexiao
 */
@Controller
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;
    
    @Autowired
    private SubscriberService userService;
    @Autowired
    private MerchandiseService productService;
    @Autowired
    private ShoppingCheService cartService;
    @Autowired
    private MnoticService mnoticService;
 

    @PostMapping("/findAll")
    @ResponseBody
    public List findAll() {
        return buyService.getBuyList();
    }
    
    @PostMapping("/deleteBuy")
    @ResponseBody
    public void deleteBuy(String id){
         buyService.deleteBuy(id);
         
    }
    
        @PostMapping("/editBuy")
    @ResponseBody
    public void editBuy(String id){
         buyService.deleteBuy(id);
         
    }
        @PostMapping("/hhhedit")
    @ResponseBody
    public void hhhedit(String id){
         buyService.deleteBuy(id);
         
    }    @PostMapping("/qqqquey")
    @ResponseBody
    public void qqqquey(String id){
         buyService.deleteBuy(id);
         
    }
        @PostMapping("/minBuy")
    @ResponseBody
    public void minBuy(String id){
         buyService.deleteBuy(id);
         
    }
    
    @PostMapping("/buy")
    public String insert(Buy buy,String productName,String productBrand,Integer productLower,Integer productHigher,String productDesc,HttpServletRequest request){
        buy.setBhigher(productHigher);
        buy.setBlower(productLower);
        buy.setPbrand(productBrand);
        buy.setPdesc(productDesc);
        buy.setPname(productName);
        buyService.addBuy(buy);
        System.out.println(buy.getPname());
        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkk");
           List<Merchandises> list2 = productService.getBookList();
            request.setAttribute("list2", list2);
            List<Merchandises> list1 = productService.getDigitalList();
            request.setAttribute("list1", list1);
            List<Merchandises> list3 = productService.getMpbileMerchandisesList();
            request.setAttribute("list3", list3);
            List<Notice> list4 = mnoticService.getNoticeList();
            request.setAttribute("list4", list4);
         
        return "index";
        
    }
    
    
    
    
}
