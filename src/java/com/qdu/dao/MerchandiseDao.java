/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Merchandises;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface MerchandiseDao {
      //获取某一用户发布的所有活动的列表
    List<Merchandises> getAllByPuid(String id);
     Object insert(Merchandises merchandise);

    //传入一个包含更新后的产品信息的Merchandise对象，更新产品信息到数据库
    void update(Merchandises merchandise);

    //根据产品编号删除单个产品
    void deleteById(String id);

    //根据产品编号查询单个产品
    Merchandises getOneById(String id);

    //获取所有产品的列表
    List<Merchandises> getAll();
    List<Merchandises> getMobilephoneAll();
    List<Merchandises> getBookAll();
    List<Merchandises> getDigitalAll();

    //根据页码和每页记录数量查询指定的产品列表
    List<Merchandises> getListByPageNumberAndSize(int pageNumber, int pageSize);
}
    


