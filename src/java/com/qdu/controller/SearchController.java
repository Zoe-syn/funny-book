/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Merchandises;
import com.qdu.entity.Notice;
import com.qdu.entity.Subscribers;
import com.qdu.service.SearchService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/findSearch")

    public String findsearch(HttpSession session, String keyword) {

        List<Merchandises> sp = searchService.getSearchMerchandiseList(keyword);
        session.setAttribute("plist", sp);

        return "search";
    }

    @ResponseBody
    public void diven(@PathVariable("id") String id) {

        searchService.getSearchProductList(id);

    }

    @ResponseBody
    public void Bianji(@PathVariable("id") String id) {
        searchService.getSearchProductList(id);
    }

    @ResponseBody
    public void chakan(@PathVariable("id") String id) {
//       String pid= req.getParameter("id");
        searchService.getSearchMerchandiseList(id);
    }

    @PostMapping("/add")
    public String Add(String uname, String upwd, HttpSession session, HttpServletRequest request) {

        searchService.getSearchProductList(upwd);
        return "index"; //如果验证通过，跳转到index页面

    }
}
