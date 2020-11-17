package com.qdu.entity;
// Generated 2019-12-1 16:55:01 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="Products"
    ,schema="dbo"
    ,catalog="FunnyBook"
)
public class Products  implements java.io.Serializable{


     private String pid;
     private String pname;
     private BigDecimal pprice;
     private String categoryName;
     private String uid;
     private String pbrand;
     private String pdesc;

    public Products() {
    }

	
    public Products(String pid, String pname, BigDecimal pprice, String categoryName, String uid, String pdesc) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.categoryName = categoryName;
        this.uid = uid;
        this.pdesc = pdesc;
    }
    public Products(String pid, String pname, BigDecimal pprice, String categoryName, String uid, String pbrand, String pdesc) {
       this.pid = pid;
       this.pname = pname;
       this.pprice = pprice;
       this.categoryName = categoryName;
       this.uid = uid;
       this.pbrand = pbrand;
       this.pdesc = pdesc;
    }
   
     @Id 

    
    @Column(name="PID", unique=true, nullable=false, length=15)
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    
    @Column(name="Pname", nullable=false)
    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    
    @Column(name="Pprice", nullable=false, precision=18)
    public BigDecimal getPprice() {
        return this.pprice;
    }
    
    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    
    @Column(name="CategoryName", nullable=false)
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    @Column(name="UID", nullable=false, length=15)
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    
    @Column(name="Pbrand")
    public String getPbrand() {
        return this.pbrand;
    }
    
    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    
    @Column(name="Pdesc", nullable=false)
    public String getPdesc() {
        return this.pdesc;
    }
    
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }




}


