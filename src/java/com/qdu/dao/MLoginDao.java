/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Manager;



public interface MLoginDao {

    Manager getOneByName(String name);
//    void update(String pwd);
    String getCurrentPwd();

}
