/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.ShoppingChe;
import com.qdu.entity.Notice;
import com.qdu.entity.Merchandises;
import com.qdu.entity.Subscribers;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MnoticService;
import com.qdu.service.MerchandiseService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lenovo
 */
@Controller
public class ShoppingCheController {

    @Autowired
    private ShoppingCheService shoppingCheService;
    @Autowired
    private MerchandiseService productService;
    @Autowired
    private MnoticService mnoticService;

    @RequestMapping("/addShoppingChe")
    public String insert(ShoppingChe shoppingChe, HttpSession session, HttpServletRequest request) {
        Merchandises p = (Merchandises) session.getAttribute("product");
        System.out.println(p);
        Subscribers u = (Subscribers) session.getAttribute("user");
        List shoppingCheList = new ArrayList();
        shoppingChe.setUid(u.getUid());
        shoppingChe.setCprice(p.getPprice());
        shoppingChe.setPid(p.getPid());
        shoppingChe.setPname(p.getPname());
        System.out.println(shoppingChe.getPid());
        System.out.println("Null?" + shoppingCheService.getShoppingCheByPId(shoppingChe.getPid(), u.getUid()));
        if (null == shoppingCheService.getShoppingCheByPId(shoppingChe.getPid(), u.getUid())) {
            shoppingCheService.addShoppingChe(shoppingChe);
            shoppingCheList.add(shoppingChe);
//           session.setAttribute("shoppingChe", shoppingChe);
        } else {
            ShoppingChe shoppingChe2 = shoppingCheService.getShoppingCheByPId(shoppingChe.getPid(), u.getUid());
            int i = shoppingChe2.getCquantity();
            int j = i + 1;
            shoppingChe2.setCquantity(j);
            System.out.println("我被执行了");
            System.out.println(shoppingChe2.getCquantity());
            shoppingCheService.updateShoppingChe(shoppingChe2);
            shoppingCheList.add(shoppingChe2);
        }
        session.setAttribute("shoppingCheList", shoppingCheList);

        //
        // List<ShoppingChe> clist = shoppingCheService.getShoppingCheList(u.getUid());
//        int f = 0;
//       
//        for (ShoppingChe c : clist) {
//            if ((p.getPid()).equals(c.getPid())) {
//                f = 1;
//                i = c.getCquantity();
//            }
//            break;
//        }
        //System.out.println(shoppingChe.getPname());
        List<Merchandises> list = productService.getMerchandisesList();

        System.out.println(list);

        request.setAttribute("list", list);

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

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        shoppingCheService.deleteShoppingChe(id);
//        return "index";
    }
    
    @RequestMapping("/edit/{id}")
     @ResponseBody
    public void life(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        shoppingCheService.deleteShoppingChe(id);
//        return "index";
    }
     @ResponseBody
    public void diven(@PathVariable("id") String id) {

        shoppingCheService.updateShoppingChe(id);

    }
     @ResponseBody
    public void Bianji(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        shoppingCheService.getShoppingCheByPId(id, id);
//        return "index";
    }
     @ResponseBody
    public void chakan(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        shoppingCheService.getListByPageNumberAndSize(0, 0);
//        return "index";
    }
}
