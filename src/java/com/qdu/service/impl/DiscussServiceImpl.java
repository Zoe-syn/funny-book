/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.DiscussDao;
import com.qdu.entity.CommentSubscriberId;
import com.qdu.entity.CommentUserId;
import com.qdu.entity.Discuss;
import com.qdu.service.DiscussService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Echo
 */
@Service
public class DiscussServiceImpl implements DiscussService{
    
    @Autowired
    private DiscussDao pcommentDao;

    @Override
    public void addDiscuss(Discuss pcomment) {
        pcommentDao.insert(pcomment);
    }

    @Override
    public void updateDiscuss(Discuss pcomment) {
        pcommentDao.update(pcomment);
    }

    @Override
    public List<Discuss> getCommentByPid(String id) {
        return pcommentDao.getDiscussByPid(id);
    }

    @Override
    public List<String> getUseridByPid(String id) {
        List<String> l1 = new ArrayList<String>();
        List<Discuss> comment = pcommentDao.getDiscussByPid(id);
        for(Discuss one:comment){
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
    public Discuss getDiscuss(CommentUserId id) {
        return pcommentDao.getDiscussById(id);
    }

    @Override
    public void addLikeNum(CommentSubscriberId id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<String> getSubscriberidByPid(String pid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addBookDiscuss(Discuss bookcomment) {
        pcommentDao.insert(bookcomment);
    }

    @Override
    public void updateBookDiscuss(Discuss bookcomment) {
        pcommentDao.update(bookcomment);
    }

    @Override
    public List<Discuss> getCommentByBookid(String bookid) {
        return pcommentDao.getDiscussByPid(bookid);
    }

    @Override
    public List<String> getUseridByBookid(String bookid) {
               List<String> booklist = new ArrayList<String>();
        List<Discuss> comment = pcommentDao.getDiscussByPid(bookid);
        for(Discuss one:comment){
            String buid = one.getId().getUid();
            booklist .add(buid);
        }
        return booklist;
    }

}
