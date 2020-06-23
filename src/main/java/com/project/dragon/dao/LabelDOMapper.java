package com.project.dragon.dao;

import com.project.dragon.dataobject.LabelDO;

import java.util.List;

public interface LabelDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(LabelDO record);

    int insertSelective(LabelDO record);

    LabelDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LabelDO record);

    int updateByPrimaryKey(LabelDO record);

    List<LabelDO> queryAll();

    LabelDO byLabelType(String labelType);
}