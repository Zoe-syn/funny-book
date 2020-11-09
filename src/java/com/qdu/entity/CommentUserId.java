/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *这是一个复合主键类
 * @author Echo
 */
@Embeddable
public class CommentUserId implements Serializable{
    
    private String pid;
    private String uid;

    public CommentUserId() {
    }

    
    
    public CommentUserId(String pid, String uid) {
        this.pid = pid;
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    
    
}
