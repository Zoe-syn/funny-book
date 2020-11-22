/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Cart;
import com.qdu.entity.Notice;
import com.qdu.entity.Products;
import com.qdu.entity.Users;
import com.qdu.service.CartService;
import com.qdu.service.MnoticService;
import com.qdu.service.ProductService;
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
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private MnoticService mnoticService;

    @RequestMapping("/addCart")
    public String insert(Cart cart, HttpSession session, HttpServletRequest request) {
        Products p = (Products) session.getAttribute("product");
        System.out.println(p);
        Users u = (Users) session.getAttribute("user");
        List cartList = new ArrayList();
        cart.setUid(u.getUid());
        cart.setCprice(p.getPprice());
        cart.setPid(p.getPid());
        cart.setPname(p.getPname());
        System.out.println(cart.getPid());
        System.out.println("Null?" + cartService.getCartByPId(cart.getPid(), u.getUid()));
        if (null == cartService.getCartByPId(cart.getPid(), u.getUid())) {
            cartService.addCart(cart);
            cartList.add(cart);
//           session.setAttribute("cart", cart);
        } else {
            Cart cart2 = cartService.getCartByPId(cart.getPid(), u.getUid());
            int i = cart2.getCquantity();
            int j = i + 1;
            cart2.setCquantity(j);
            System.out.println("我被执行了");
            System.out.println(cart2.getCquantity());
            cartService.updateCart(cart2);
            cartList.add(cart2);
        }
        session.setAttribute("cartList", cartList);

        //
        // List<Cart> clist = cartService.getCartList(u.getUid());
//        int f = 0;
//       
//        for (Cart c : clist) {
//            if ((p.getPid()).equals(c.getPid())) {
//                f = 1;
//                i = c.getCquantity();
//            }
//            break;
//        }
        //System.out.println(cart.getPname());
        List<Products> list = productService.getProductsList();

        System.out.println(list);

        request.setAttribute("list", list);

        List<Products> list2 = productService.getBookList();
        request.setAttribute("list2", list2);
        List<Products> list1 = productService.getDigitalList();
        request.setAttribute("list1", list1);
        List<Products> list3 = productService.getMpbileProductsList();
        request.setAttribute("list3", list3);
        List<Notice> list4 = mnoticService.getNoticeList();
        request.setAttribute("list4", list4);
        return "index";

    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        cartService.deleteCart(id);
//        return "index";
    }
}
