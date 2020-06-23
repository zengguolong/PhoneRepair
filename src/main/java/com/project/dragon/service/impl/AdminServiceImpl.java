package com.project.dragon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dragon.dao.AdminDOMapper;
import com.project.dragon.dao.UserDAOMapper;
import com.project.dragon.dataobject.AdminDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDOMapper adminDOMapper;

    @Autowired
    private UserDAOMapper userDAOMapper;

    @Override
    public AdminDO adminLogin(AdminDO adminDO) {
        return adminDOMapper.adminLogin(adminDO);
    }

    @Override
    public PageInfo<UserDAO> queryAllUser(int page,int size) {
        PageHelper.startPage(page,size);
        List<UserDAO> userDAOList = userDAOMapper.queryAllUser();
        PageInfo<UserDAO> pageInfo = new PageInfo<>(userDAOList);
        return pageInfo;
    }

    @Override
    public void delete(String username) {

    }
}
