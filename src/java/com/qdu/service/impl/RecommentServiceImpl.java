/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.RecommentDao;
import com.qdu.entity.Recomment;
import com.qdu.service.RecommentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Echo
 */
@Service
public class RecommentServiceImpl implements RecommentService{

    @Autowired
    private RecommentDao recommentDao;
    
    @Override
    public Recomment getRecommentById(int id) {
        return recommentDao.getOneById(id);
    }

    @Override
    public List<Recomment> getRecommentListByPid(String pid) {
        return recommentDao.getAllByPid(pid);
    }
    
    @Override
    public Object addRecomment(Recomment recomment) {
       return recommentDao.insert(recomment);
    }

    @Override
    public void updateRecomment(Recomment recomment) {
        recommentDao.update(recomment);
    }

    @Override
    public void deleteRecomment(int id) {
        recommentDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return recommentDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override
    public List<String> getUidByPid(String id) {
        List<String> userList = new ArrayList<String>();
        List<Recomment> l1 = recommentDao.getAllByPid(id);
        for(Recomment one:l1){
            String uid = one.getUid();
            userList.add(uid);
        }
        return userList;
    }
}
