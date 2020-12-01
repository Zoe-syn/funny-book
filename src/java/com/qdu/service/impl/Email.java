
 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package com.qdu.service.impl;
 
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;


@Component
public class Email {

    // 发件人 账号和密码	
    public static final String MY_EMAIL_ACCOUNT = "jiaxingsenghy@163.com";
    public static final String MY_EMAIL_PASSWORD = "IGPSRFRFMMSLBBFZ";// 密码,是你自己的设置的授权码	
    // SMTP服务器(这里用的163 SMTP服务器)
    public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
    public static final String SMTP_163_PORT = "25";// 端口号,这个是163使用到的;QQ的应该是465或者875	
    // 收件人	
    public static String RECEIVE_EMAIL_ACCOUNT;

    public void sendEmailToUser(String email) {
        System.out.println("准备发送！！！！");
        try {
            //收件人为传入的参数
            RECEIVE_EMAIL_ACCOUNT = email;
            Properties p = new Properties();
            p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);// 主机名
            p.setProperty("mail.smtp.port", SMTP_163_PORT);// 端口号
            p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
            p.setProperty("mail.smtp.auth", "true");
            p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");
            p.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
            Session session = Session.getInstance(p, new Authenticator() {
                // 设置认证账户信息
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
                }
            });
            session.setDebug(true);
            System.out.println("创建邮件");
            MimeMessage message = new MimeMessage(session);
            // 发件人
            message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
            // 收件人和抄送人
            message.setRecipients(Message.RecipientType.TO, RECEIVE_EMAIL_ACCOUNT);
//		message.setRecipients(Message.RecipientType.CC, MY_EMAIL_ACCOUNT);
            // 内容(这个内容还不能乱写,有可能会被SMTP拒绝掉;多试几次吧)
            message.setSubject("<三味书屋>");
            message.setContent("<h3>尊敬的用户:</h3>"
                    + "<br>"
                    +"<p>欢迎使用三味书屋，有问题请联系我们！</p>", "text/html;charset=UTF-8");
            message.setSentDate(new Date());
            message.saveChanges();
            System.out.println("准备发送");
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmailToSubscriber(String recieve) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendEmailToSubscriber(String recieve) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}


 