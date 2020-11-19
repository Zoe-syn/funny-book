package com.qdu.dao;

import com.qdu.entity.Recomment;
import java.util.List;

/**
 * RecommentDao接口，定义对Recomment表的操作有哪些
 *
 * @author NIIT
 */
public interface RecommentDao {

    //传入一个包含新回复信息的Recomment对象，插入新回复到数据库
    Object insert(Recomment recomment);

    //传入一个包含更新后的回复信息的Recomment对象，更新回复信息到数据库
    void update(Recomment recomment);

    //根据编号删除单个回复
    void deleteById(int id);

    //根据编号查询单个回复
    Recomment getOneById(int id);

    //根据活动编号获取该活动的所有回复的列表
    List<Recomment> getAllByPid(String pid);

    //根据页码和每页记录数量查询指定的回复列表
    List<Recomment> getListByPageNumberAndSize(int pageNumber, int pageSize);
}
