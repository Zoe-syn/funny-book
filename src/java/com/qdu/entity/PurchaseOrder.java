package com.qdu.entity;
// Generated 2019-12-1 16:55:01 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PurchaseOrder generated by hbm2java
 */
@Entity
@Table(name="PurchaseOrder"
    ,schema="dbo"
    ,catalog="FunnyBook"
)
public class PurchaseOrder  implements java.io.Serializable{


     private String orderId;
     private String cid;
     private String pid;
     private String receiverName;
     private BigDecimal pprice;
     private String pstatus;
     private String buyerAddress;
     private String buyerPhone;
     private Date orderDate;

    public PurchaseOrder() {
    }

	
    public PurchaseOrder(String orderId, String pid, String receiverName, BigDecimal pprice, String pstatus, String buyerAddress) {
        this.orderId = orderId;
        this.pid = pid;
        this.receiverName = receiverName;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.buyerAddress = buyerAddress;
    }
    public PurchaseOrder(String orderId, String cid, String pid, String receiverName, BigDecimal pprice, String pstatus, String buyerAddress, String buyerPhone, Date orderDate) {
       this.orderId = orderId;
       this.cid = cid;
       this.pid = pid;
       this.receiverName = receiverName;
       this.pprice = pprice;
       this.pstatus = pstatus;
       this.buyerAddress = buyerAddress;
       this.buyerPhone = buyerPhone;
       this.orderDate = orderDate;
    }
   
     @Id 

    
    @Column(name="OrderID", unique=true, nullable=false)
    public String getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    
    @Column(name="CID", length=15)
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(String cid) {
        this.cid = cid;
    }

    
    @Column(name="PID", nullable=false, length=15)
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    
    @Column(name="ReceiverName", nullable=false)
    public String getReceiverName() {
        return this.receiverName;
    }
    
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    
    @Column(name="Pprice", nullable=false, precision=18)
    public BigDecimal getPprice() {
        return this.pprice;
    }
    
    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    
    @Column(name="Pstatus", nullable=false)
    public String getPstatus() {
        return this.pstatus;
    }
    
    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    
    @Column(name="BuyerAddress", nullable=false)
    public String getBuyerAddress() {
        return this.buyerAddress;
    }
    
    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    
    @Column(name="BuyerPhone")
    public String getBuyerPhone() {
        return this.buyerPhone;
    }
    
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="OrderDate", length=23)
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }




}


