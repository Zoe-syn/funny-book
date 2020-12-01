package com.qdu.service.impl;

import com.qdu.dao.QueryDataDaoDemo;
import com.qdu.entity.Merchandises;
import com.qdu.service.QueryDataServiceDemo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryDataServiceImplDemo implements QueryDataServiceDemo{
    
    @Autowired
    QueryDataDaoDemo queryDataDaoDemo;

    @Override
    public List<Merchandises> getDataByCondition(String name, Integer price1,Integer price2) {
        return queryDataDaoDemo.getDataByCondition(name,price1,price2);
    }
    
}
