/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.service.ShaixuanService;
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
@RequestMapping("/shaixuan")
public class ShaixuanController {
    
    @Autowired
    private ShaixuanService shaixuanService;

    @RequestMapping("/shai")
    @ResponseBody
    public List shai(){
        
        return shaixuanService.getShaiXuanList();
        

    }



   
    
}

//@Controller
//@RequestMapping("/shaixuan")
//public class ShaixuanController {
//    
//    @Autowired
//    private ShaixuanService shaixuanService;
//    
//    @PostMapping("/shai")
//    @ResponseBody
//    public List shai() {
//        return shaixuanService.getShaiXuanList();
//    }
//}
