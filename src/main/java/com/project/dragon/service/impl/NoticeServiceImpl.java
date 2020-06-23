package com.project.dragon.service.impl;

import com.project.dragon.dao.NoticeDOMapper;
import com.project.dragon.dataobject.NoticeDO;
import com.project.dragon.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDOMapper noticeDOMapper;

    @Override
    public List<NoticeDO> queryAll() {
        return noticeDOMapper.queryAll();
    }

    @Override
    public void updateNotice(NoticeDO noticeDO) {
        noticeDOMapper.updateByPrimaryKey(noticeDO);
    }

    @Override
    public void addNotice(NoticeDO noticeDO) {
        noticeDOMapper.insertSelective(noticeDO);
    }

    @Override
    public void delete(String noticeId) {
        noticeDOMapper.deleteByPrimaryKey(noticeId);
    }

    @Override
    public NoticeDO byNoticeId(String noticeID) {
        return noticeDOMapper.selectByPrimaryKey(noticeID);
    }
}
