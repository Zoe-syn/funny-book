/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Products;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface ProductDao {
      //获取某一用户发布的所有活动的列表
    List<Products> getAllByPuid(String id);
     Object insert(Products product);

    //传入一个包含更新后的产品信息的Product对象，更新产品信息到数据库
    void update(Products product);

    //根据产品编号删除单个产品
    void deleteById(String id);

    //根据产品编号查询单个产品
    Products getOneById(String id);

    //获取所有产品的列表
    List<Products> getAll();
    List<Products> getMobilephoneAll();
    List<Products> getBookAll();
    List<Products> getDigitalAll();

    //根据页码和每页记录数量查询指定的产品列表
    List<Products> getListByPageNumberAndSize(int pageNumber, int pageSize);
}
    


