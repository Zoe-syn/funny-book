/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Echo
 */
@Entity
@Table(name="Pcomment"
    ,schema="dbo"
    ,catalog="C2C"
)
public class Pcomment implements Serializable {

  
    
//    @Id
//     private String aid;
//     private String uid;
     @EmbeddedId
     private CommentUserId id;
     private String cdetail;
     private String clike;
     private String ctime;
     private String ruid;

    public Pcomment() {
    }

    public Pcomment(CommentUserId id, String cdetail, String clike, String ctime) {
        this.id = id;
        this.cdetail = cdetail;
        this.clike = clike;
        this.ctime = ctime;
    }

   
    

    public Pcomment(CommentUserId id, String cdetail, String clike, String ctime, String ruid) {
        this.id = id;
        this.cdetail = cdetail;
        this.clike = clike;
        this.ctime = ctime;
        this.ruid = ruid;
    }

    public CommentUserId getId() {
        return id;
    }

    public void setId(CommentUserId id) {
        this.id = id;
    }

    public String getCdetail() {
        return cdetail;
    }

    public void setCdetail(String cdetail) {
        this.cdetail = cdetail;
    }

    public String getClike() {
        return clike;
    }

    public void setClike(String clike) {
        this.clike = clike;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

     
     
   
 

   
     
      
}
