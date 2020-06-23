package com.project.dragon.dao;

import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.viewobject.BusinessVO;

import java.util.List;

public interface OrderDOMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    OrderDO selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);

    List<OrderDO> queryAll();

    List<OrderDO> queryUserAllOrder(String userId);

    List<OrderDO> byUsernameOrder(String username);

    List<OrderDO> byOrderStatus(OrderDO orderDO);

    BusinessVO queryAllBusiness();

}