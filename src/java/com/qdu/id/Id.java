/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.id;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Id {
    //订单编号后缀（核心部分）
    private static long code;
    
    // 生成订单编号
    public static synchronized Long getOrderCode() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 1;
        m += code;
        return m;
    }
    
}
