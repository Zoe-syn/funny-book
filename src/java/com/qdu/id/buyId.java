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
public class buyId extends Id{
     public static String PREFIX = "B";//只需要生成一个类 改掉前缀和方法名即可
     
      public static synchronized String getBuyIdCode() {
         return PREFIX +Id.getOrderCode();
      }
      
      //测试用
     public static void main(String[] args) {
         System.out.println(buyId.getBuyIdCode());//用括号中的调用
    }
}
