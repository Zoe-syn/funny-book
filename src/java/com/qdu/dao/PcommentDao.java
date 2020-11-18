/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.CommentUserId;
import com.qdu.entity.Pcomment;
import java.util.List;

/**
 *
 * @author Echo
 */
public interface PcommentDao {
    
    //传入一个包含新评级信息的Acomment对象，插入新评级到数据库
    void insert(Pcomment pcomment);

    //传入一个包含更新后的评级信息的Acomment对象，更新评级信息到数据库
    void update(Pcomment pcomment);
    
    //传入一个评论id，得到该评论id对应的全部评论
    List<Pcomment> getPcommentByPid(String id);
    
    //传入一个复合主键，得到对应的该条评论
    Pcomment getPcommentById(CommentUserId id);
    
    //传入当前评论的复合主键，更新点赞数+1,并返回当前点赞数
    void updateLikeNum(CommentUserId id);
    
  
    
}
