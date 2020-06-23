package com.project.dragon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dragon.dao.BusinessDOMapper;
import com.project.dragon.dao.OrderDOMapper;
import com.project.dragon.dao.UserDAOMapper;
import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private BusinessDOMapper businessDOMapper;

    @Autowired
    private UserDAOMapper userDAOMapper;

    @Override
    public List<OrderDO> queryAllOrder() {
        return orderDOMapper.queryAll();
    }

    @Override
    public PageInfo<OrderDO> pageQueryOrder(int page, int size) {
        PageHelper.startPage(page,size);
        List<OrderDO> orderDOList = orderDOMapper.queryAll();
        PageInfo<OrderDO> pageInfo = new PageInfo<>(orderDOList);
        return pageInfo;
    }

    @Override
    public PageInfo<OrderDO> QueryUserAllOrder(String userId, int page, int size) {
        PageHelper.startPage(page,size);
        List<OrderDO> orderDOList = orderDOMapper.queryUserAllOrder(userId);
        PageInfo<OrderDO> pageInfo = new PageInfo<>(orderDOList);
        return pageInfo;
    }

    @Override
    public void updateOrder(OrderDO orderDO) {
        orderDOMapper.updateByPrimaryKeySelective(orderDO);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDOMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public OrderDO byIdOrder(String orderId) {
        return orderDOMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public void finishOrder(OrderDO orderDO) {
         //更改其状态为1已完结
         orderDOMapper.updateByPrimaryKey(orderDO);

         //更改营业总表的订单+1 总金额也相对应的增加
         BusinessDO businessDO =  businessDOMapper.query();
         if(businessDO==null)
             throw new DragonException(ResultEnum.BUSINESS_NOT_EXIST);
         businessDO.setOrderNumber(businessDO.getOrderNumber()+1);
         businessDO.setAmount(businessDO.getAmount()+orderDO.getOrderAmount());
         businessDOMapper.updateByPrimaryKey(businessDO);
    }

    @Override
    public void cancelOrder(String orderId) {
        //查看该订单信息是否存在
        OrderDO orderDO = orderDOMapper.selectByPrimaryKey(orderId);
        if (orderDO == null)
            throw new DragonException(ResultEnum.ORDER_NOT_EXIST);
        if(!orderDO.getOrderStatus().equals("0"))
            throw new DragonException(20048,"该订单无法退款");
        orderDO.setOrderStatus("3");
        orderDOMapper.updateByPrimaryKey(orderDO);

        //给用户退款
        UserDAO user = new UserDAO();
        user.setUsername(orderDO.getOrderUsername());
        UserDAO userDAO = userDAOMapper.selectByUserName(user);

        BigDecimal userMoney = new BigDecimal(userDAO.getMoney());
        BigDecimal price = new BigDecimal(orderDO.getOrderAmount());
        Double money = userMoney.add(price).doubleValue();
        money = (double) Math.round(money * 100) / 100;

        userDAO.setMoney(money);
        userDAOMapper.updateByPrimaryKey(userDAO);
    }

    @Override
    public List<OrderDO> byOrderStatus(String orderStatus,String orderUsername) {
        OrderDO orderDO = new OrderDO();
        orderDO.setOrderUsername(orderUsername);
        orderDO.setOrderStatus(orderStatus);
        return orderDOMapper.byOrderStatus(orderDO);
    }

}
