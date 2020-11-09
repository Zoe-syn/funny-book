package com.qdu.entity;
// Generated 2019-12-1 16:55:01 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Massage generated by hbm2java
 */
@Entity
@Table(name="Massage"
    ,schema="dbo"
    ,catalog="C2C"
)
public class Massage  implements java.io.Serializable{


     private String mid;
     private String pid;
     private String mcontent;
     private Date mreleasetime;
     private String uname;
     private String mparentId;

    public Massage() {
    }

	
    public Massage(String mid) {
        this.mid = mid;
    }
    public Massage(String mid, String pid, String mcontent, Date mreleasetime, String uname, String mparentId) {
       this.mid = mid;
       this.pid = pid;
       this.mcontent = mcontent;
       this.mreleasetime = mreleasetime;
       this.uname = uname;
       this.mparentId = mparentId;
    }
   
     @Id 

    
    @Column(name="MID", unique=true, nullable=false, length=15)
    public String getMid() {
        return this.mid;
    }
    
    public void setMid(String mid) {
        this.mid = mid;
    }

    
    @Column(name="PID", length=15)
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    
    @Column(name="MContent", length=2000)
    public String getMcontent() {
        return this.mcontent;
    }
    
    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MReleasetime", length=23)
    public Date getMreleasetime() {
        return this.mreleasetime;
    }
    
    public void setMreleasetime(Date mreleasetime) {
        this.mreleasetime = mreleasetime;
    }

    
    @Column(name="UName")
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    
    @Column(name="MParent_id", length=15)
    public String getMparentId() {
        return this.mparentId;
    }
    
    public void setMparentId(String mparentId) {
        this.mparentId = mparentId;
    }




}

