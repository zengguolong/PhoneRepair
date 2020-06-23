package com.project.dragon.service;

import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.dto.UserDTO;

import java.util.List;

public interface UserService {

    //根据用户名查询用户信息
    UserDAO byFindUser(UserDAO userDAO);

    //注册
    void register(UserDAO userDAO);

    //登录接口查询
    UserDAO login(UserDAO userDAO);

    //用户下单
    void buyerUser(String username,Double amount,String detail,String remark);

    //根据用户id查询用户信息
    UserDTO byUserId(String userId);

    //用户充值
    void userCharge(String username,Double amount);

    //根据用户名查询该用户下的所有订单
    List<OrderDO> byUsernameOrder(String username);

    //修改金额(扣钱)
    void modifyMoney(String username,Double money);

}
