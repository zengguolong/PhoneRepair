package com.project.dragon.service;

import com.project.dragon.dataobject.LabelDO;

import java.util.List;

public interface LabelService {

    //查询所有手机标签信息
    List<LabelDO> queryAll();

    void add(LabelDO labelDO);

    void delete(String labelId);

    void update(LabelDO labelDO);

    //根据id查询某个手机类型标签
    LabelDO byLabelId(String labelId);


    LabelDO byLabelType(String labelType);
}
