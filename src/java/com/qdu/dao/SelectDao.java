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
 * @author Lenovo
 */
public interface SelectDao {
    
    
    List<Merchandises> getAll();
    
     List<Merchandises> getAllBook();
}
