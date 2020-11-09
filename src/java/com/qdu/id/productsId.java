
package com.qdu.id;

/**
 *
 * @author lenovo
 */
public class productsId extends Id{
    public static String PREFIX = "P";
    
    public static synchronized String getProductsIdCode() {
         return PREFIX +Id.getOrderCode();
      }
}
