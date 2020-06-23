package com.project.dragon.service.impl;

import com.project.dragon.dao.LabelDOMapper;
import com.project.dragon.dataobject.LabelDO;
import com.project.dragon.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDOMapper labelDOMapper;

    @Override
    public List<LabelDO> queryAll() {
        return labelDOMapper.queryAll();
    }

    @Override
    public void add(LabelDO labelDO) {
        labelDOMapper.insertSelective(labelDO);
    }

    @Override
    public void delete(String labelId) {
        labelDOMapper.deleteByPrimaryKey(labelId);
    }

    @Override
    public void update(LabelDO labelDO) {
        labelDOMapper.updateByPrimaryKey(labelDO);
    }

    @Override
    public LabelDO byLabelId(String labelId) {
        return labelDOMapper.selectByPrimaryKey(labelId);
    }

    @Override
    public LabelDO byLabelType(String labelType) {
        return labelDOMapper.byLabelType(labelType);
    }
}
