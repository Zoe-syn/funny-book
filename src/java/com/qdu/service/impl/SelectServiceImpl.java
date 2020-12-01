/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.SelectDao;
import com.qdu.service.SelectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class SelectServiceImpl implements SelectService{

    @Autowired
    private SelectDao selectDao;

    @Override
    public List getShaiXuanList() {
        return selectDao.getAll();
    }
    
 
}
