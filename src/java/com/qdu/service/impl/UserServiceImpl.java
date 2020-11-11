/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service.impl;

import com.qdu.dao.UserDao;
import com.qdu.entity.Users;
import com.qdu.service.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lihexiao
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override 
    public Users getUserById(String id) {
        return userDao.getOneById(id);
    }

    @Override
    public Users getUserByName(String name) {
        return userDao.getOneByName(name);
    }
    

    @Override
    public List getUserList() {
        return userDao.getAll();
    }

    @Override
    public Object addUser(Users user) {
        return userDao.insert(user);
    }

    @Override
    public void updateUser(Users user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }

    @Override
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return userDao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

    @Override
    public Users validateLogin(String uname, String upwd) {
        Users user =  userDao.getOneByName(uname);
        if (null != user && upwd.equals(user.getUpwd())) {
            return user;
        }
        return null;
    }

}
