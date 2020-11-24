package com.qdu.controller;

import com.qdu.entity.Products;
import com.qdu.service.QueryDataServiceDemo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/queryData")
public class QueryDataControllerDemo {

    @Autowired
    QueryDataServiceDemo queryDataServiceDemo;

    @RequestMapping("/to_shaixuan")
    public String to_ShaixuanDemo() {
        return "shaixuan";
    }

    @RequestMapping("/queryDataByCondition")
    @ResponseBody
    public List<Products> queryDataByCondition(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "price", required = false, defaultValue = "0-100000") String price
    ) {
        System.out.println("------------------------------------------------------");
        name = name.equals("undefined") ? null : name;
//        System.out.println(price);
//        System.out.println(name);
        int p1 = Integer.parseInt(price.split("-")[0]);
        int p2 = Integer.parseInt(price.split("-")[1]);
//        System.out.println(p1+"  "+p2);
        System.out.println("dddddddd");
        System.out.println("........................................"+queryDataServiceDemo.getDataByCondition(name, p1, p2).size());
        return queryDataServiceDemo.getDataByCondition(name, p1, p2);
    }

}
