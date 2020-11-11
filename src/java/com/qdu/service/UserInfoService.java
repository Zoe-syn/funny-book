/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.UserInfo;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lihexiao
 */
public interface UserInfoService {
    UserInfo getUserInfoById(String id);

    List getUserInfoList();

    Object addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void deleteUserInfo(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
}
