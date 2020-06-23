package com.project.dragon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dragon.dao.ManagerDOMapper;
import com.project.dragon.dataobject.ManagerDO;
import com.project.dragon.service.ManagerService;
import com.project.dragon.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDOMapper managerDOMapper;

    @Override
    public void add(ManagerDO managerDO) {
        managerDOMapper.insertSelective(managerDO);
    }

    @Override
    public void adds(List<ManagerDO> managerDOList) {
        for (ManagerDO managerDO : managerDOList){
            ManagerDO manager = new ManagerDO();
            manager.setId(KeyUtils.genUniqueKey());
            manager.setPhoneType(managerDO.getPhoneType());
            manager.setPrice(managerDO.getPrice());
            manager.setMessage(managerDO.getMessage());
            managerDOMapper.insertSelective(manager);
        }
    }

    @Override
    public void delete(String id) {
        managerDOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ManagerDO managerDO) {
        managerDOMapper.updateByPrimaryKey(managerDO);
    }

    @Override
    public List<ManagerDO> queryAll() {
        return managerDOMapper.queryAll();
    }

    @Override
    public PageInfo<ManagerDO> pageQueryManager(int page, int size) {
        PageHelper.startPage(page, size);
        List<ManagerDO> managerDOList = managerDOMapper.queryAll();
        PageInfo<ManagerDO> pageInfo = new PageInfo<>(managerDOList);
        return pageInfo;
    }

    @Override
    public ManagerDO byManagerId(String id) {
        return managerDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ManagerDO> byPhoneType(String phoneType) {
        return managerDOMapper.selectByPhoneType(phoneType);
    }

}
