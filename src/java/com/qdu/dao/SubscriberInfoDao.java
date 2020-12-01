
package com.qdu.dao;

import com.qdu.entity.SubscriberInfo;
import java.util.List;
import javax.servlet.http.HttpSession;


public interface SubscriberInfoDao {
     Object insert(SubscriberInfo subscriberInfo);

    //传入一个包含更新后的产品信息的Product对象，更新产品信息到数据库
    void update(SubscriberInfo subscriberInfo);

    //根据产品编号删除单个产品
    void deleteById(String id);

    //根据产品编号查询单个产品
    SubscriberInfo getOneById(String id);

    //获取所有产品的列表
    List<SubscriberInfo> getAll();
    
    List<SubscriberInfo> getAllBook();
    List<SubscriberInfo> getListByPageNumberAndSize(int pageNumber, int pageSize);

}
    

