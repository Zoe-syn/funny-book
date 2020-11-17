/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Manager;
import com.qdu.service.MLoginService;
import com.qdu.service.MnoticService;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MLoginController {

    @Autowired
    private MnoticService mnoticService;

    @Autowired
    private MLoginService mLoginService;

    @PostMapping("/Mlogin")
    public String login(String username, String password, Model model, HttpSession session) {

        Manager m = mLoginService.validateLogin(username, password);
        if (null == m) {

            return "login-1"; //如果验证不通过，跳转到fail页面
        } else {
            //将用户对象作为属性添加到Model对象中，返回给页面
            //这样可以在页面上通过user这个属性名获取该用户对象
            session.setAttribute("a", m.getAname());
            
            session.setAttribute("noticeList", mnoticService.getNoticeList());

            return "mindex"; //如果验证通过，跳转到success页面
        }
    }

    @RequestMapping("/mlogout")
    public String logout(HttpServletRequest req) throws Exception {
        //退出登录也就意味着结束会话
        //如果有会话，返回会话，否则返回null
        HttpSession session = req.getSession(false);
        if (null != session) {
            session.invalidate(); //调用invalidate()方法可以立刻让会话结束
        }       //退出登录后回到首页
        return "login-1";
    }

}
