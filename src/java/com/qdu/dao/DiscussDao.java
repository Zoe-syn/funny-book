/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.CommentUserId;
import com.qdu.entity.Discuss;
import java.util.List;

/**
 *
 * @author Echo
 */
public interface DiscussDao {
    
    //传入一个包含新评级信息的Acomment对象，插入新评级到数据库
    void insert(Discuss pcomment);
    
    void insertPinglun(Discuss bookcomment);

    //传入一个包含更新后的评级信息的Acomment对象，更新评级信息到数据库
    void update(Discuss pcomment);
    
    void updatePinglun(Discuss bookcomment);
    
    //传入一个评论id，得到该评论id对应的全部评论
    List<Discuss> getDiscussByPid(String id);
    
    
    List<Discuss> getDiscussByBookid(String bookid);
    
    //传入一个复合主键，得到对应的该条评论
    Discuss getDiscussById(CommentUserId id);
    
    Discuss getDiscussByBookId(CommentUserId userbookid);
    
    Discuss getDiscussByName(CommentUserId uname);
    
    //传入当前评论的复合主键，更新点赞数+1,并返回当前点赞数
    void updateLikeNum(CommentUserId id);
    
  
    
}
