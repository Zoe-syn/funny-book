package com.qdu.dao;

import com.qdu.entity.Merchandises;
import java.util.List;

public interface QueryDataDaoDemo {
    
    List<Merchandises> getDataByCondition(String name,Integer price1,Integer price2); 
}
