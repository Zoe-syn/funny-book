///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.qdu.filter;
//
//import com.qdu.entity.Users;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
///**
// *
// * @author lenovo
// */
//public class AuthorizedInterceptor implements HandlerInterceptor {
//
//    private static final String[] IGORE_URL = {"/addCart","/buy"};
//
//    @Override
//    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        boolean flag = false;
//        String servletPath = request.getServletPath();
//        for (String s : IGORE_URL) {
//            if (servletPath.contains(s)) {
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
//            Users user = (Users) request.getSession().getAttribute("user");
//            if (user == null) {
//                request.setAttribute("message", "请先登录再访问网站！");
//                String ctxPath = request.getContextPath() + "/";
//                request.getRequestDispatcher(ctxPath + "fail").forward(request, response);
//                return flag;
//            } else {
//                flag = true;
//            }
//        }
//        return flag;
//    }
//
//}
