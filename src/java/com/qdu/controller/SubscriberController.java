/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Notice;
import com.qdu.entity.Merchandises;
import com.qdu.entity.Subscribers;
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

/**
 *
 * @author
 */
@Controller
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private MerchandiseService productService;
    @Autowired
    private ShoppingCheService cartService;
    @Autowired
    private MnoticService mnoticService;

    @PostMapping("/login")
    public String login(String uname, String upwd, HttpSession session, HttpServletRequest request) {

//        String name=(String)session.getAttribute(uname);
//        String pwd=(String)session.getAttribute(upwd);
        Subscribers u = subscriberService.validateLogin(uname, upwd);
        if (null == u) {
            return "fail"; //如果验证不通过，跳转到fail页面
        } else {
            //将用户对象作为属性添加到Model对象中，返回给页面
            //这样可以在页面上通过subscriber这个属性名获取该用户对象
            session.setAttribute("subscriber", u);
            session.setAttribute("subscriberId", u.getUid());
            System.out.println("OKKKKKKKKKK");
            System.out.println(u.getUname());
            List<Merchandises> list2 = productService.getBookList();
            request.setAttribute("list2", list2);
            List<Merchandises> list1 = productService.getDigitalList();
            request.setAttribute("list1", list1);
            List<Merchandises> list3 = productService.getMpbileMerchandisesList();
            request.setAttribute("list3", list3);
            List<Notice> list4 = mnoticService.getNoticeList();
            request.setAttribute("list4", list4);
            return "index"; //如果验证通过，跳转到index页面

        }

    }
}
