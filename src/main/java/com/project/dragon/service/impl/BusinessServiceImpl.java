package com.project.dragon.service.impl;

import com.project.dragon.dao.BusinessDOMapper;
import com.project.dragon.dao.OrderDOMapper;
import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.service.BusinessService;
import com.project.dragon.service.OrderService;
import com.project.dragon.viewobject.BusinessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDOMapper businessDOMapper;

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    public BusinessDO query() {
        return businessDOMapper.query();
    }

    @Override
    public void updateBusiness(BusinessDO businessDO) {
        businessDOMapper.updateByPrimaryKey(businessDO);
    }

    @Override
    public BusinessVO queryAllBusiness() {
        BusinessVO businessVO = orderDOMapper.queryAllBusiness();
        return businessVO;
    }
}
