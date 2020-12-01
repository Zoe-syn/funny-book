package com.qdu.controller;

import com.qdu.entity.Notice;
import com.qdu.entity.Merchandises;
import com.qdu.entity.Subscribers;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MnoticService;
import com.qdu.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qdu.service.SubscriberServiceDemo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/subscriber")
public class SubscriberControllerDemo {

    @Autowired
    SubscriberServiceDemo subscriberServiceDemo;
       @Autowired
    private ShoppingCheService cartService;
    @Autowired
    private MerchandiseService productService;

    @Autowired
    private MnoticService mnoticService;


    @RequestMapping("/to_registerDemo")
    public String to_RegisterDemo() {
        return "registerDemo";
    }
    
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(@RequestParam("name") String name) {
        int result = subscriberServiceDemo.getSubscriberByName(name);
        if (result != 0) {
            return "success";
        } else {
            return "good good study,day day up !";
        }
    }

    @RequestMapping("/register")
    public String registerOne(Subscribers u, HttpServletRequest request) {
        u.setUid("U" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        subscriberServiceDemo.insertOne(u);
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

    @RequestMapping("/test")
    @ResponseBody
    public int test() {
        int result = subscriberServiceDemo.getSubscriberByName("李红66");
        System.out.println("李红" + result);
        return result;
    }

}
