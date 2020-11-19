package com.qdu.service;

import com.qdu.entity.Recomment;
import java.util.List;

public interface RecommentService {

    /**
     * 传入一个活动aid，得到该活动对应的全部回复的回复人uid
     *
     */
     List<String> getUidByPid(String id);

    /**
     * 根据编号获取一个回复的所有信息
     *
     * @param id 字符串表示的编号
     * @return 一个Recomment对象，包含回复信息
     */
    Recomment getRecommentById(int id);

    /**
     * 获取所有回复的列表
     *
     * @return 一个列表，包含某一个活动的所有回复的信息
     */
    List<Recomment> getRecommentListByPid(String pid);

    /**
     * 添加一个新回复
     *
     * @param recomment 一个包含新回复信息的Recomment对象
     */
    Object addRecomment(Recomment recomment);

    /**
     * 更新一个新回复
     *
     * @param recomment 一个包含新回复信息的Recomment对象
     */
    void updateRecomment(Recomment recomment);

    /**
     * 根据编号删除一个回复
     *
     * @param id 字符串表示的编号
     */
    void deleteRecomment(int id);

    /**
     * 根据页码和页面记录大小获取指定页的记录
     *
     * @param pageNumber
     * @param pageSize
     * @return 一个列表，列表中包含本页应该显示的所有回复
     */
    List getListByPageNumberAndSize(int pageNumber, int pageSize);
}
