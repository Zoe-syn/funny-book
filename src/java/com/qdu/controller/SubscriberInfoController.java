package com.qdu.controller;

import com.qdu.service.impl.Email;
import com.qdu.entity.SubscriberInfo;
import com.qdu.service.SubscriberInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * StudentController 用于处理学生相关的一些请求
 *
 * @author Anna
 */
@Controller
@RequestMapping("/subscriberinfo")
public class SubscriberInfoController {

    @Autowired
    private SubscriberInfoService subscriberInfoService;
    @Autowired
    private Email email;

    @PostMapping("/sendEmail")
    @ResponseBody
    public void sendEmail(String recieve){
        email.sendEmailToSubscriber(recieve);
    }

   @PostMapping("/findAll")
    @ResponseBody
    public List findAll() {
        return subscriberInfoService.getSubscriberInfoList();
    }
    


    @PostMapping("/add_subscriberinfo")
    @ResponseBody
    public String addSubscriberInfo(SubscriberInfo s) {
        return  (String)subscriberInfoService.addSubscriberInfo(s);

    }
    @PostMapping("/get_subscriberinfo_to_edit")
    @ResponseBody
    public SubscriberInfo getSubscriberInfoToEdit(String subscriberInfoid) {
        return subscriberInfoService.getSubscriberInfoById(subscriberInfoid);
    }

    @PostMapping("/edit_subscriberinfo")
    @ResponseBody
    public void editSubscriberInfo(SubscriberInfo s) {
        subscriberInfoService.updateSubscriberInfo(s);

    }


    @PostMapping("/delete")
    @ResponseBody
    public void delete(String subscriberInfoid) {
        subscriberInfoService.deleteSubscriberInfo(subscriberInfoid);
    }

}
