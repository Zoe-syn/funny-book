/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.CommentUserId;
import com.qdu.entity.Notice;
import com.qdu.entity.Pcomment;
import com.qdu.entity.Products;
import com.qdu.entity.Recomment;
import com.qdu.entity.Users;
import com.qdu.service.CartService;
import com.qdu.service.MnoticService;
import com.qdu.service.PcommentService;
import com.qdu.service.ProductService;
import com.qdu.service.RecommentService;
import com.qdu.service.UserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lenovo
 */
@Controller
public class productController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;
    @Autowired
    private MnoticService mnoticService;
    
     @Autowired
    private PcommentService pcommentService;
    @Autowired
    private RecommentService recommentService;

    @PostMapping("/findAll")
    @ResponseBody
    public List findAll() {
        return productService.getProductsList();
    }

    @PostMapping("/productAdd")
    public String insert(Products p, String pname, String pbrand, BigDecimal pprice, String pkind, String pdesc, HttpServletRequest request) {
        p.setCategoryName(pkind);
        p.setPbrand(pbrand);
        p.setPdesc(pdesc);
        p.setPname(pname);
        p.setPprice(pprice);
        productService.addProducts(p);
        System.out.println(p.getPname());
        System.out.println("okk");

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

   @RequestMapping("/getOne")
    public String getOne(String pid,HttpSession session,Model model) {
       Products p= productService.getProductsById(pid);
       session.setAttribute("product", p);

      // id为活动编号、auid为发布人编号、bid为复合主键
      
      // 根据活动编号得到发布该活动的用户编号
        String puid = productService.getPuidById(pid);
        model.addAttribute("users", userService.getUserById(puid));
      

        //根据活动编号得到某些用户对该活动的全部评论
        model.addAttribute("commentList", pcommentService.getCommentByPid(pid));
        //根据活动编号得到对该活动评论的这些用户的详细信息
        List<String> list = pcommentService.getUseridByPid(pid);
        List<Users> userList = new ArrayList<Users>();
        for (String str : list) {
            Users u =  userService.getUserById(str);
            userList.add(u);
        }
        model.addAttribute("userList", userList);

        //再通过这些用户id获取到他们的名字信息
        List<Recomment> l1 = recommentService.getRecommentListByPid(pid);
        List<Users> l2 = new ArrayList<Users>();
        for (Recomment one : l1) {
            String id = one.getPid();
            List<String> l3 = recommentService.getUidByPid(id);
            for (String str : l3) {
                Users u =userService.getUserById(str);
                l2.add(u);
            }
        }
        model.addAttribute("recommentUserList", l2);
        //得到某些用户对于某一个活动的全部回复
        model.addAttribute("recommentList", l1);
       return "detail";
    }
    
    



@PostMapping(value = "/likeNum")
    @ResponseBody
    public int addLikeNum(String id1, String id2, int num, Model model) {
        CommentUserId id = new CommentUserId(id1, id2);
        pcommentService.addLikeNum(id);
        num = num + 1;
        return num;
    }

    @PostMapping("/get_recomment_to_add")
    @ResponseBody
    public Map getRecommentToadd(String uid, String ruid) {
        Users u1 = userService.getUserById(uid);
        Users u2 = userService.getUserById(ruid);
        String name1 = u1.getUname();
        String name2 = u2.getUname();

        Map m = new HashMap();
        m.put("uid", name1);
        m.put("ruid", name2);

        return m;
    }



    

     //传入活动id，回复人的id，以及被回复人的id，返回一个回复表的对象
    @PostMapping(value = "/add_recomment")
    @ResponseBody
    public Integer addRecomment(String pid, String uname, String runame, String time, String detail) {
        String u1 = userService.getUserByName(uname).getUid();
        String u2 = userService.getUserByName(runame).getUid();

        Recomment recomment = new Recomment(pid, u1, u2, detail, time);
        return (Integer) recommentService.addRecomment(recomment);
    }

    @PostMapping(value = "/add_comment")
    @ResponseBody
    public void addComment(String pid, String uid, String cdetail, String clike, String ctime) {
         CommentUserId id = new  CommentUserId(pid, uid);
        Pcomment pcomment= new  Pcomment(id, cdetail, clike, ctime);
        pcommentService.addPcomment(pcomment);
    }

  

}
