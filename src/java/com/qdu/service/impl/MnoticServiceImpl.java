/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.MnoticDao;
import com.qdu.entity.Notice;
import com.qdu.service.MnoticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MnoticServiceImpl implements MnoticService {

    @Autowired
    private MnoticDao mnoticDao;
   

    @Override
    public List getNoticeList() {
        return mnoticDao.getAll();
    }

    @Override
    public void updateNotice(Notice notice) {
         mnoticDao.update(notice);
    }

    @Override
    public void deleteNotice(String id) {
         mnoticDao.deleteById(id);
    }

    @Override
    public Notice getNoticeById(String id) {
       return mnoticDao.getOneById(id);
    }
    
}
