package com.project.dragon.dao;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.UserDAO;

import java.util.List;

public interface UserDAOMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserDAO record);

    int insertSelective(UserDAO record);

    UserDAO selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserDAO record);

    int updateByPrimaryKey(UserDAO record);

    UserDAO selectByUserName(UserDAO userDAO);

    UserDAO login(UserDAO userDAO);

    List<UserDAO> queryAllUser();
}