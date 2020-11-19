package com.qdu.service;

import com.qdu.entity.Products;
import java.util.List;

public interface QueryDataServiceDemo {
    
    List<Products> getDataByCondition(String name,Integer price1,Integer price2); 
    
}
