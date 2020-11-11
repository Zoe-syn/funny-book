package com.qdu.controller;

import com.qdu.entity.Notice;
import com.qdu.entity.Products;
import com.qdu.entity.Users;
//import com.qdu.service.CartService;
//import com.qdu.service.MnoticService;
//import com.qdu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qdu.service.UserServiceDemo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserControllerDemo {

    @Autowired
    UserServiceDemo userServiceDemo;
       @Autowired
//    private CartService cartService;
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private MnoticService mnoticService;


    @RequestMapping("/to_registerDemo")
    public String to_RegisterDemo() {
        return "registerDemo";
    }
    
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(@RequestParam("name") String name) {
        int result = userServiceDemo.getUserByName(name);
        if (result != 0) {
            return "success";
        } else {
            return "good good study,day day up !";
        }
    }

    @RequestMapping("/register")
    public String registerOne(Users u, HttpServletRequest request) {
        u.setUid("U" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        userServiceDemo.insertOne(u);
//           List<Products> list2 = productService.getBookList();
//        request.setAttribute("list2", list2);
//        List<Products> list1 = productService.getDigitalList();
//        request.setAttribute("list1", list1);
//        List<Products> list3 = productService.getMpbileProductsList();
//        request.setAttribute("list3", list3);
//        List<Notice> list4 = mnoticService.getNoticeList();
//        request.setAttribute("list4", list4);
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public int test() {
        int result = userServiceDemo.getUserByName("李红66");
        System.out.println("李红" + result);
        return result;
    }

}
