/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.UserInfoDao;
import com.qdu.entity.UserInfo;
import com.qdu.service.UserInfoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfoById(String id) {

        return userInfoDao.getOneById(id);
    }

    @Override
    public List getUserInfoList() {
        return userInfoDao.getAll();
    }
 

    public Object addUserInfo(UserInfo userInfo) {
//        String OId = (String) userInfo.setUserInfoId1(orderCode.getOrderCode());
//        HttpSession session= sessionFactory.getCurrentSession();
//        userInfoDao.insert(userInfo);
        return userInfoDao.insert(userInfo);
    } 


    @Override
    public void updateUserInfo(UserInfo userInfo) {

        userInfoDao.update(userInfo);
    }

    @Override
    public void deleteUserInfo(String id) {

        userInfoDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return userInfoDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }
}
