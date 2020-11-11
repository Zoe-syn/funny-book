package com.qdu.controller;

//import com.qdu.service.impl.Email;
import com.qdu.entity.UserInfo;
import com.qdu.service.UserInfoService;
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
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
//    @Autowired
//    private Email email;

//    @PostMapping("/sendEmail")
//    @ResponseBody
//    public void sendEmail(String recieve){
//        email.sendEmailToUser(recieve);
//    }

   @PostMapping("/findAll")
    @ResponseBody
    public List findAll() {
        return userInfoService.getUserInfoList();
    }
    


    @PostMapping("/add_userinfo")
    @ResponseBody
    public String addUserInfo(UserInfo s) {
        return  (String)userInfoService.addUserInfo(s);

    }
    @PostMapping("/get_userinfo_to_edit")
    @ResponseBody
    public UserInfo getUserInfoToEdit(String userInfoid) {
        return userInfoService.getUserInfoById(userInfoid);
    }

    @PostMapping("/edit_userinfo")
    @ResponseBody
    public void editUserInfo(UserInfo s) {
        userInfoService.updateUserInfo(s);

    }


    @PostMapping("/delete")
    @ResponseBody
    public void delete(String userInfoid) {
        userInfoService.deleteUserInfo(userInfoid);
    }

}
