/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Cart;
import java.util.List;

/**
 *
 * @author lihexiao
 */
public interface CartDao {

    Object insert(Cart cart);

    //传入一个包含更新后的产品信息的Product对象，更新产品信息到数据库
    void update(Cart cart);

    //根据产品编号删除单个产品
    void deleteById(String id);

    //根据产品编号查询单个产品
    Cart getOneById(String id);
    
    //根据产品编号查询单个产品
    Cart getOneByPId(String pid,String uid);

    //获取所有产品的列表
    List<Cart> getAll(String uid);

    //根据页码和每页记录数量查询指定的产品列表
    List<Cart> getListByPageNumberAndSize(int pageNumber, int pageSize);
}
