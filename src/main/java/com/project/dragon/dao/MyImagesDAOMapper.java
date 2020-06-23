package com.project.dragon.dao;

import com.project.dragon.dataobject.MyImagesDAO;

public interface MyImagesDAOMapper {
    int deleteByPrimaryKey(String id);

    int insert(MyImagesDAO record);

    int insertSelective(MyImagesDAO record);

    MyImagesDAO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MyImagesDAO record);

    int updateByPrimaryKey(MyImagesDAO record);
}