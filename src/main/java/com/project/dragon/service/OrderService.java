package com.project.dragon.service;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.OrderDO;

import java.util.List;

public interface OrderService {

    //查询所有订单信息
    List<OrderDO> queryAllOrder();

    //分页查询订单信息
    PageInfo<OrderDO> pageQueryOrder(int page,int size);

    //根据用户id 分页查询该用户的所有订单信息
    PageInfo<OrderDO> QueryUserAllOrder(String userId,int page,int size);

    //修改订单信息
    void updateOrder(OrderDO orderDO);

    //删除订单信息
    void deleteOrder(String orderId);

    //根据id查询订单信息
    OrderDO byIdOrder(String orderId);

    //完结订单
    void finishOrder(OrderDO orderDO);

    //取消订单
    void cancelOrder(String orderId);

    // 根据订单状态查询订单列表
    List<OrderDO> byOrderStatus(String orderStatus,String orderUsername);
}
