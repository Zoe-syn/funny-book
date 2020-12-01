/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.CommentSubscriberId;
import com.qdu.entity.Notice;
import com.qdu.entity.Discuss;
import com.qdu.entity.Merchandises;
import com.qdu.entity.Recomment;
import com.qdu.entity.Subscribers;
import com.qdu.service.ShoppingCheService;
import com.qdu.service.MnoticService;
import com.qdu.service.DiscussService;
import com.qdu.service.MerchandiseService;
import com.qdu.service.RecommentService;
import com.qdu.service.SubscriberService;
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
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;
    @Autowired
    private SubscriberService userService;

    @Autowired
    private ShoppingCheService cartService;
    @Autowired
    private MnoticService mnoticService;
    
     @Autowired
    private DiscussService pcommentService;
    @Autowired
    private RecommentService recommentService;

    @PostMapping("/findAll")
    @ResponseBody
    public List findAll() {
        return merchandiseService.getMerchandisesList();
    }

    @PostMapping("/merchandiseAdd")
    public String insert(Merchandises p, String pname, String pbrand, BigDecimal pprice, String pkind, String pdesc, HttpServletRequest request) {
        p.setCategoryName(pkind);
        p.setPbrand(pbrand);
        p.setPdesc(pdesc);
        p.setPname(pname);
        p.setPprice(pprice);
        merchandiseService.addMerchandises(p);
        System.out.println(p.getPname());
        System.out.println("okk");

        List<Merchandises> list2 = merchandiseService.getBookList();
        request.setAttribute("list2", list2);
        List<Merchandises> list1 = merchandiseService.getDigitalList();
        request.setAttribute("list1", list1);
        List<Merchandises> list3 = merchandiseService.getMpbileMerchandisesList();
        request.setAttribute("list3", list3);
        List<Notice> list4 = mnoticService.getNoticeList();
        request.setAttribute("list4", list4);
        return "index";

    }

   @RequestMapping("/getOne")
    public String getOne(String pid,HttpSession session,Model model) {
       Merchandises p= merchandiseService.getMerchandisesById(pid);
       session.setAttribute("merchandise", p);

      // id为活动编号、auid为发布人编号、bid为复合主键
      
      // 根据活动编号得到发布该活动的用户编号
        String puid = merchandiseService.getPuidById(pid);
        model.addAttribute("users", userService.getSubscriberById(puid));
      

        //根据活动编号得到某些用户对该活动的全部评论
        model.addAttribute("commentList", pcommentService.getCommentByPid(pid));
        //根据活动编号得到对该活动评论的这些用户的详细信息
        List<String> list = pcommentService.getSubscriberidByPid(pid);
        List<Subscribers> userList = new ArrayList<Subscribers>();
        for (String str : list) {
            Subscribers u =  userService.getSubscriberById(str);
            userList.add(u);
        }
        model.addAttribute("userList", userList);

        //再通过这些用户id获取到他们的名字信息
        List<Recomment> l1 = recommentService.getRecommentListByPid(pid);
        List<Subscribers> l2 = new ArrayList<Subscribers>();
        for (Recomment one : l1) {
            String id = one.getPid();
            List<String> l3 = recommentService.getUidByPid(id);
            for (String str : l3) {
                Subscribers u =userService.getSubscriberById(str);
                l2.add(u);
            }
        }
        model.addAttribute("recommentSubscriberList", l2);
        //得到某些用户对于某一个活动的全部回复
        model.addAttribute("recommentList", l1);
       return "detail";
    }
    
    



@PostMapping(value = "/likeNum")
    @ResponseBody
    public int addLikeNum(String id1, String id2, int num, Model model) {
        CommentSubscriberId id = new CommentSubscriberId(id1, id2);
        pcommentService.addLikeNum(id);
        num = num + 1;
        return num;
    }

    @PostMapping("/get_recomment_to_add")
    @ResponseBody
    public Map getRecommentToadd(String uid, String ruid) {
        Subscribers u1 = userService.getSubscriberById(uid);
        Subscribers u2 = userService.getSubscriberById(ruid);
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
        String u1 = userService.getSubscriberByName(uname).getUid();
        String u2 = userService.getSubscriberByName(runame).getUid();

        Recomment recomment = new Recomment(pid, u1, u2, detail, time);
        return (Integer) recommentService.addRecomment(recomment);
    }

    @PostMapping(value = "/add_comment")
    @ResponseBody
    public void addComment(String pid, String uid, String cdetail, String clike, String ctime) {
         CommentSubscriberId id = new  CommentSubscriberId(pid, uid);
        Discuss pcomment= new  Discuss(id, cdetail, clike, ctime);
        pcommentService.addDiscuss(pcomment);
    }

  

}
