/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Echo
 */
@Entity
public class Recomment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String pid;
    private String uid;
    private String ruid;
    private String rdetail;
    private String rtime;

    public Recomment() {
    }

    public Recomment(String pid, String uid, String ruid, String rdetail, String rtime) {
        this.pid = pid;
        this.uid = uid;
        this.ruid = ruid;
        this.rdetail = rdetail;
        this.rtime = rtime;
    }

    
    public Recomment(Integer rid, String pid, String uid, String ruid, String rdetail, String rtime) {
        this.rid = rid;
        this.pid = pid;
        this.uid = uid;
        this.ruid = ruid;
        this.rdetail = rdetail;
        this.rtime = rtime;
    }


    
    
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    public String getRdetail() {
        return rdetail;
    }

    public void setRdetail(String rdetail) {
        this.rdetail = rdetail;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    
    
}
