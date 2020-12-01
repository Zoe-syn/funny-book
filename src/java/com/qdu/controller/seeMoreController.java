/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Merchandises;
import com.qdu.service.SearchService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pc
 */
@Controller
@RequestMapping("/seeMore")
public class seeMoreController {
      @Autowired
    private SearchService sousuoService;

    @GetMapping("/findSearch")
    
    public String findsearch(HttpSession session,String keyword){
        
        List<Merchandises> sp=sousuoService.getSearchMerchandiseList(keyword);
        session.setAttribute("plist", sp);


        return "sousuo";
    }
}
