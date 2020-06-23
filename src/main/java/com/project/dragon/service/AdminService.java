package com.project.dragon.service;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.AdminDO;
import com.project.dragon.dataobject.UserDAO;

import java.util.List;

public interface AdminService {

    //管理员登录
    AdminDO adminLogin(AdminDO adminDO);

    //分页查询所有用户
    PageInfo<UserDAO> queryAllUser(int page,int size);

    //删除用户
    void delete(String username);


}
