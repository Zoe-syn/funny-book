/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Users;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface UserDao {

    Object insert(Users user);

    void update(Users user);

    void deleteById(String id);

    Users getOneById(String id);
    
    Users getOneByName(String name);

    List<Users> getAll();

    List<Users> getListByPageNumberAndSize(int pageNumber, int pageSize);

    

}
