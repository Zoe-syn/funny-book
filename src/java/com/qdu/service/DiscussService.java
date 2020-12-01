/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.CommentSubscriberId;
import com.qdu.entity.CommentUserId;
import com.qdu.entity.Discuss;
import java.util.List;

/**
 *
 * @author Echo
 */
public interface DiscussService {
    /**
     * 添加一个新评级
     *
     * @param acomment 一个包含新评级信息的Acomment对象
     */
    void addDiscuss(Discuss pcomment);
    
     void addBookDiscuss(Discuss bookcomment);
     void updateBookDiscuss(Discuss bookcomment);
     List<Discuss> getCommentByBookid(String bookid);
     List<String> getUseridByBookid(String bookid);

    /**
     * 更新一个新评级
     *
     * @param acomment 一个包含新评级信息的Acomment对象
     */
    void updateDiscuss(Discuss pcomment);
    
    /**
     * 传入一个评论的活动id，得到该评论id对应的全部评论
     *
     */
     List<Discuss> getCommentByPid(String id);
     
     /**
     * 传入一个评论的活动id，得到该评论id对应的全部评论人id
     *
     */
     List<String> getUseridByPid(String id);
     
     /**
     * 传入一个评论的复合id，并将点赞数+1
     *
     */
     void addLikeNum(CommentUserId id);
     
     /**
     * ！！！！！但是如果一个用户对某一个活动有多条评论就会出错！！！！！
     * 传入一个评论的复合id，得到对应的该条评论
     *
     */
     Discuss getDiscuss(CommentUserId id);

    public void addLikeNum(CommentSubscriberId id);

    public List<String> getSubscriberidByPid(String pid);
}
