/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Notice;
import com.qdu.entity.Products;
//import com.qdu.service.MnoticService;
//import com.qdu.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lenovo
 */
@Controller
public class LogoutController {

//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private MnoticService mnoticService;

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) throws Exception {
        //退出登录也就意味着结束会话
        //如果有会话，返回会话，否则返回null
        HttpSession session = req.getSession(false);
        if (null != session) {
            session.invalidate(); //调用invalidate()方法可以立刻让会话结束
        }

//        List<Products> list2 = productService.getBookList();
//        req.setAttribute("list2", list2);
//        List<Products> list1 = productService.getDigitalList();
//        req.setAttribute("list1", list1);
//        List<Products> list3 = productService.getMpbileProductsList();
//        req.setAttribute("list3", list3);
//        List<Notice> list4 = mnoticService.getNoticeList();
//        req.setAttribute("list4", list4);
//        //退出登录后回到首页
        return "index";
    }
}
