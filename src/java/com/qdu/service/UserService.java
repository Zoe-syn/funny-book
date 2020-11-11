/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Users;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author lihexiao
 */
public interface UserService {

    Users getUserById(String id);

    
//    Users getUserByName(String name);

    List getUserList();

    Object addUser(Users user);

    void updateUser(Users user);

    void deleteUser(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);

    public Users validateLogin(String username, String password);

     Users getUserByName(String name);
    
}
