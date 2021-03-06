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
 * SubscriberInfo generated by hbm2java
 */
@Entity
@Table(name="SubscriberInfo"
    ,schema="dbo"
    ,catalog="FunnyBook"
)
public class SubscriberInfo  implements java.io.Serializable{


     private String uid;
     private String ugender;
     private String uprovince;
     private String ucity;
     private String ucontact;
     private String uname;
     private String uaddress;
     private String uzipCode;
     private String uemail;
     private String uidentityNumber;
     private Date ubirthday;
     private int uwarning;
     private boolean ustatus;

    public SubscriberInfo() {
    }

	
    public SubscriberInfo(String uid, String ucontact, String uemail, int uwarning, boolean ustatus) {
        this.uid = uid;
        this.ucontact = ucontact;
        this.uemail = uemail;
        this.uwarning = uwarning;
        this.ustatus = ustatus;
    }
    public SubscriberInfo(String uid, String ugender, String uprovince, String ucity, String ucontact, String uname, String uaddress, String uzipCode, String uemail, String uidentityNumber, Date ubirthday, int uwarning, boolean ustatus) {
       this.uid = uid;
       this.ugender = ugender;
       this.uprovince = uprovince;
       this.ucity = ucity;
       this.ucontact = ucontact;
       this.uname = uname;
       this.uaddress = uaddress;
       this.uzipCode = uzipCode;
       this.uemail = uemail;
       this.uidentityNumber = uidentityNumber;
       this.ubirthday = ubirthday;
       this.uwarning = uwarning;
       this.ustatus = ustatus;
    }
   
     @Id 

    
    @Column(name="UID", unique=true, nullable=false, length=15)
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }

    
    @Column(name="UGender", length=2)
    public String getUgender() {
        return this.ugender;
    }
    
    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    
    @Column(name="UProvince")
    public String getUprovince() {
        return this.uprovince;
    }
    
    public void setUprovince(String uprovince) {
        this.uprovince = uprovince;
    }

    
    @Column(name="UCity")
    public String getUcity() {
        return this.ucity;
    }
    
    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    
    @Column(name="UContact", nullable=false)
    public String getUcontact() {
        return this.ucontact;
    }
    
    public void setUcontact(String ucontact) {
        this.ucontact = ucontact;
    }

    
    @Column(name="UName")
    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    
    @Column(name="UAddress")
    public String getUaddress() {
        return this.uaddress;
    }
    
    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    
    @Column(name="UZipCode")
    public String getUzipCode() {
        return this.uzipCode;
    }
    
    public void setUzipCode(String uzipCode) {
        this.uzipCode = uzipCode;
    }

    
    @Column(name="UEmail")
    public String getUemail() {
        return this.uemail;
    }
    
    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    
    @Column(name="UIdentityNumber")
    public String getUidentityNumber() {
        return this.uidentityNumber;
    }
    
    public void setUidentityNumber(String uidentityNumber) {
        this.uidentityNumber = uidentityNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="UBirthday", length=10)
    public Date getUbirthday() {
        return this.ubirthday;
    }
    
    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    
    @Column(name="Uwarning", nullable=false)
    public int getUwarning() {
        return this.uwarning;
    }
    
    public void setUwarning(int uwarning) {
        this.uwarning = uwarning;
    }

    
    @Column(name="Ustatus", nullable=false)
    public boolean isUstatus() {
        return this.ustatus;
    }
    
    public void setUstatus(boolean ustatus) {
        this.ustatus = ustatus;
    }




}


