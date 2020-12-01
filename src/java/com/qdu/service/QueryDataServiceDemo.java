package com.qdu.service;

import com.qdu.entity.Merchandises;
import java.util.List;

public interface QueryDataServiceDemo {
    
    List<Merchandises> getDataByCondition(String name,Integer price1,Integer price2); 
    
}
