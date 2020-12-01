/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.service;

import com.qdu.entity.SubscriberInfo;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lihexiao
 */
public interface SubscriberInfoService {
    SubscriberInfo getSubscriberInfoById(String id);

    List getSubscriberInfoList();

    Object addSubscriberInfo(SubscriberInfo subscriberInfo);

    void updateSubscriberInfo(SubscriberInfo subscriberInfo);

    void deleteSubscriberInfo(String id);

    List getListByPageNumberAndSize(int pageNumber, int pageSize);
    
}
