package com.project.dragon.dao;

import com.project.dragon.dataobject.ManagerDO;

import java.util.List;

public interface ManagerDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(ManagerDO record);

    int insertSelective(ManagerDO record);

    ManagerDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ManagerDO record);

    int updateByPrimaryKey(ManagerDO record);

    List<ManagerDO> queryAll();

    List<ManagerDO> selectByPhoneType(String  phoneType);

    //ManagerDO selectByProductId(String productId);
}