package com.project.dragon.dao;

import com.project.dragon.dataobject.AdminDO;
import com.project.dragon.dataobject.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminDO record);

    int insertSelective(AdminDO record);

    AdminDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminDO record);

    int updateByPrimaryKey(AdminDO record);

    AdminDO adminLogin(AdminDO adminDO);

}