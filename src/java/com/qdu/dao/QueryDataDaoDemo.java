package com.qdu.dao;

import com.qdu.entity.Products;
import java.util.List;

public interface QueryDataDaoDemo {
    
    List<Products> getDataByCondition(String name,Integer price1,Integer price2); 
}
