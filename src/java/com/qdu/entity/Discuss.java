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
@Table(name="Discuss"
    ,schema="dbo"
    ,catalog="FunnyBook"
)
public class Discuss implements Serializable {

  
    
//    @Id
//     private String aid;
//     private String uid;
     @EmbeddedId
     private CommentUserId id;
     private String cdetail;
     private String clike;
     private String ctime;
     private String ruid;

    public Discuss() {
    }

    public Discuss(CommentUserId id, String cdetail, String clike, String ctime) {
        this.id = id;
        this.cdetail = cdetail;
        this.clike = clike;
        this.ctime = ctime;
    }

   
    

    public Discuss(CommentUserId id, String cdetail, String clike, String ctime, String ruid) {
        this.id = id;
        this.cdetail = cdetail;
        this.clike = clike;
        this.ctime = ctime;
        this.ruid = ruid;
    }

    public Discuss(CommentSubscriberId id, String cdetail, String clike, String ctime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
