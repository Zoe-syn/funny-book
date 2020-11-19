/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.ShaixuanDao;
import com.qdu.service.ShaixuanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class ShaixuanServiceImpl implements ShaixuanService{

    @Autowired
    private ShaixuanDao shaixuanDao;

    @Override
    public List getShaiXuanList() {
        return shaixuanDao.getAll();
    }
    
 
}
