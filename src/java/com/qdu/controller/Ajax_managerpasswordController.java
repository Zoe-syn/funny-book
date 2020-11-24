package com.qdu.controller;

import com.qdu.service.MLoginService;
import com.qdu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mpwd")
public class Ajax_managerpasswordController {

    @Autowired
    private MLoginService mLoginService;

    @PostMapping(value = "/yzmm", produces = "text/html;charset=utf-8")
    @ResponseBody //该注解说明控制器方法返回的内容为响应正文内容，也就是返回给前端的数据
    public String yzmm(String old_password) {
        boolean result = mLoginService.checkPwd(old_password);
        if (result == true) {
            return "验证通过";
        } else {
            return "与原来密码不一致";
        }
    }

    @PostMapping(value = "/yzyz", produces = "text/html;charset=utf-8")
    @ResponseBody //该注解说明控制器方法返回的内容为响应正文内容，也就是返回给前端的数据
    public String yzyz(String again_password, String new_password) {
        if (again_password.equals(new_password)) {
            return "";
        } else {
            return "两次密码不一致,请重新输入";
        }
    }

    @PostMapping(value = "/gxmm", produces = "text/html;charset=utf-8")
    @ResponseBody //该注解说明控制器方法返回的内容为响应正文内容，也就是返回给前端的数据
    public void gxmm(String new_password) {
//        mLoginService.updatemm(new_password);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("update Manager set apwd=:apwd where aid=:aid");
        query.setParameter("apwd", new_password);
        query.setParameter("aid", "A001");
        //执行更新，如果是增删改操作，调用executeUpdate()方法
        //该方法返回一个整数，表示首影响的行数
        int rows = query.executeUpdate();
        session.getTransaction().commit(); //一定要提交事务，增删改需要在事务内执行
        HibernateUtil.closeSession(session);
        
    }
}
