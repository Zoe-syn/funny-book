/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.Notice;
import java.util.List;

/**
 *
 * @author 花花hy
 */
public interface MnoticService {
  Notice getNoticeById(String id);

    List getNoticeList();

    void updateNotice(Notice notice);

    void deleteNotice(String id);
}
