/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.MerchandiseCategory;
import com.qdu.service.MerchandiseCategoryService;
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

public class MerchandiseCategoryController {

    @Autowired
    private MerchandiseCategoryService productCategoryService;

    @PostMapping("/selectOption")
    @ResponseBody
    public List<MerchandiseCategory> selectOption(HttpServletRequest request, HttpServletResponse response) {

        List<MerchandiseCategory> c = productCategoryService.getCategoryName();

        return c;
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/addOption")
    @ResponseBody
    public List<MerchandiseCategory> addOption(HttpServletRequest request, HttpServletResponse response) {

        String c = productCategoryService.toString();
        return null;

    }

    @PostMapping("/editOption")
    @ResponseBody
    public List<MerchandiseCategory> editOption(HttpServletRequest request, HttpServletResponse response) {

        List<MerchandiseCategory> c = productCategoryService.getCategoryName();

        return c;
    }

}
