/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.MwelcomCountDao;
import com.qdu.service.MwelcomCountService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class MwelcomCountServiceImpl implements MwelcomCountService{

    @Resource
    private MwelcomCountDao mwelcomCountDao;
    
    @Override
    public Long getyhsl() {
        return mwelcomCountDao.getyhs();
    }

    @Override
    public Long getspsl() {
        return mwelcomCountDao.getsps();
    }

    @Override
    public Long getddsl() {
        return mwelcomCountDao.getdds();
    }
 
    
}
