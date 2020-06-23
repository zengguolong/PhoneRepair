package com.project.dragon.service;

import com.project.dragon.dataobject.NoticeDO;

import java.util.List;

public interface NoticeService {

    //查询所有公告信息
    List<NoticeDO> queryAll();

    //修改公告信息
    void updateNotice(NoticeDO noticeDO);

    //添加公告信息
    void addNotice(NoticeDO noticeDO);

    //删除公告信息
    void delete(String noticeId);

    //根据id查询公告信息
    NoticeDO byNoticeId(String noticeID);
}
