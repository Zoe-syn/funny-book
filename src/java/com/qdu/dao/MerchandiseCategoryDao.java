/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.MerchandiseCategory;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface MerchandiseCategoryDao {
    //获取所有产品的列表
    List<MerchandiseCategory> getCategoryName();
}
