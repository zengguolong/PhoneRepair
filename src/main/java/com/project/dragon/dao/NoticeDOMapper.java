package com.project.dragon.dao;

import com.project.dragon.dataobject.NoticeDO;

import java.util.List;

public interface NoticeDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(NoticeDO record);

    int insertSelective(NoticeDO record);

    NoticeDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NoticeDO record);

    int updateByPrimaryKey(NoticeDO record);

    List<NoticeDO> queryAll();
}