
package com.qdu.id;

/**
 *
 * @author lenovo
 */
public class merchandisesId extends Id{
    public static String PREFIX = "P";
    
    public static synchronized String getMerchandisesIdCode() {
         return PREFIX +Id.getOrderCode();
      }
}
