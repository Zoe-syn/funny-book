/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.PcommentDao;
import com.qdu.entity.CommentUserId;
import com.qdu.entity.Pcomment;
import com.qdu.service.PcommentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Echo
 */
@Service
public class PcommentServiceImpl implements PcommentService{
    
    @Autowired
    private PcommentDao pcommentDao;

    @Override
    public void addPcomment(Pcomment pcomment) {
        pcommentDao.insert(pcomment);
    }

    @Override
    public void updatePcomment(Pcomment pcomment) {
        pcommentDao.update(pcomment);
    }

    @Override
    public List<Pcomment> getCommentByPid(String id) {
        return pcommentDao.getPcommentByPid(id);
    }

    @Override
    public List<String> getUseridByPid(String id) {
        List<String> l1 = new ArrayList<String>();
        List<Pcomment> comment = pcommentDao.getPcommentByPid(id);
        for(Pcomment one:comment){
            String uid = one.getId().getUid();
            l1.add(uid);
        }
        return l1;
    }

    @Override
    public void addLikeNum(CommentUserId id) {
        pcommentDao.updateLikeNum(id);
    }

    @Override
    public Pcomment getPcomment(CommentUserId id) {
        return pcommentDao.getPcommentById(id);
    }

}
