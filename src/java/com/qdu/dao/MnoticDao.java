/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.dao;

import com.qdu.entity.Notice;
import java.util.List;

/**
 *
 * @author 花花hy
 */
public interface MnoticDao {

    List<Notice> getAll();

    void update(Notice notice);

    Notice getOneById(String id);

    void deleteById(String id);
}
