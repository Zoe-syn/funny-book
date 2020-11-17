/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.controller;

import com.qdu.entity.Notice;
import com.qdu.service.MnoticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 花花hy
 */
@Controller
@RequestMapping("/notice")
public class MnoticController {

    @Autowired
    private MnoticService mnoticService;

    @PostMapping("/findAllNotice")
    @ResponseBody
    public List findAllNotice() {
        return mnoticService.getNoticeList();
    }

    @GetMapping("/edit")
    @ResponseBody
    public String editNotice(Notice n) {
        mnoticService.updateNotice(n);
        System.out.println("更新成功！");
        return "redirect:/mindex";
    }

    @GetMapping("/delete")

    public String delete(String id) {
        mnoticService.deleteNotice(id);
        return "redirect:/mindex";

    }

}
