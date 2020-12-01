/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.ShoppingChe;
import java.util.List;

/**
 *
 * @author lihexiao
 */
public interface ShoppingCheDao {

    Object insert(ShoppingChe shoppingChe);

    //传入一个包含更新后的产品信息的Product对象，更新产品信息到数据库
    void update(ShoppingChe shoppingChe);

    //根据产品编号删除单个产品
    void deleteById(String id);

    //根据产品编号查询单个产品
    ShoppingChe getOneById(String id);
    
    //根据产品编号查询单个产品
    ShoppingChe getOneByPId(String pid,String uid);

    //获取所有产品的列表
    List<ShoppingChe> getAll(String uid);
    
    List<ShoppingChe> getAllBook(String bookid);
    
    List<ShoppingChe> getListByPageNumberAndSize(int pageNumber, int pageSize);

}
