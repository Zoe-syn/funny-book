/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.id;

/**
 *
 * @author lenovo
 */
public class uId extends Id{
     public static String PREFIX = "U";//只需要生成一个类 改掉前缀和方法名即可
     
      public static synchronized String getUIdCode() {
         return PREFIX +Id.getOrderCode();
      }
}
