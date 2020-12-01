/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.service.SelectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lenovo
 */


@Controller
@RequestMapping("/select")
public class SelectController {
    
    @Autowired
    private SelectService selectService;

    @RequestMapping("/shai")
    @ResponseBody
    public List shai(){
        
        return selectService.getShaiXuanList();
    }


    @RequestMapping("/to_shaixuan")
    public String to_ShaixuanDemo() {
        return "shaixuan";
    }
    
    @RequestMapping("/to_searchDemo")
    public String to_searchDemo() {
        return "searchDemo";
    }
    
    @RequestMapping("/to_delDemo")
    public String to_delDemo() {
        return "delDemo";
    }
    
    @RequestMapping("/add")
    public String add() {
        return "add";
    }

   //@Controller
//@RequestMapping("/select")
//public class SelectController {
//    
//    @Autowired
//    private SelectService selectService;
//    
//    @PostMapping("/shai")
//    @ResponseBody
//    public List shai() {
//        return selectService.getShaiXuanList();
//    }
//}
//
    
}

