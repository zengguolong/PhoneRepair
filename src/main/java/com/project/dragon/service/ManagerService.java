package com.project.dragon.service;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.ManagerDO;

import java.util.List;

public interface ManagerService {

    //添加一个手机价格管理
    void add(ManagerDO managerDO);

    //添加多个手机价格管理信息
    void adds(List<ManagerDO> managerDOList);

    //删除手机价格管理信息
    void delete(String id);

    //更改手机价格管理
    void update(ManagerDO managerDO);

    //查询所有手机价格管理信息
    List<ManagerDO> queryAll();

    //分页查询手机价格管理信息
    PageInfo<ManagerDO> pageQueryManager(int page,int size);

    //根据id查询手机价格信息
    ManagerDO byManagerId(String id);

    //根据手机型号查询手机价格管理信息
    List<ManagerDO> byPhoneType(String phoneType);

}
