/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.ProductCategory;
import com.qdu.service.ProductCategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lenovo
 */
@Controller

public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
     
    @PostMapping("/selectOption")
    @ResponseBody
    public List<ProductCategory> selectOption(HttpServletRequest request,HttpServletResponse response){

        List<ProductCategory> c =productCategoryService.getCategoryName();

        return c;
    }

}
