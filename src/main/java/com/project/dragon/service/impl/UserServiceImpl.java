package com.project.dragon.service.impl;

import com.project.dragon.converter.UserConvert;
import com.project.dragon.dao.OrderDOMapper;
import com.project.dragon.dao.UserDAOMapper;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.dto.UserDTO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.UserService;
import com.project.dragon.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOMapper userDAOMapper;

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private UserService userService;

    @Override
    public UserDAO byFindUser(UserDAO userDAO) {
        return userDAOMapper.selectByUserName(userDAO);
    }

    @Override
    public void register(UserDAO userDAO) {
        userDAOMapper.insertSelective(userDAO);
    }

    @Override
    public UserDAO login(UserDAO userDAO) {
        return userDAOMapper.login(userDAO);
    }

    @Override
    @Transactional
    public void buyerUser(String username, Double amount, String detail,String remark) {
        UserDAO user = new UserDAO();
        user.setUsername(username);
        UserDAO userDAO = userService.byFindUser(user);
        if (userDAO == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(userDAO.getUserId());
        orderDO.setOrderUsername(userDAO.getUsername());
        orderDO.setOrderPhone(userDAO.getPhone());
        orderDO.setOrderAmount(amount);
        orderDO.setOrderDetail(detail);
        orderDO.setOrderStatus("0");
        orderDO.setOrderId(KeyUtils.genUniqueKey());
        orderDO.setOrderRemark(remark);
        orderDOMapper.insertSelective(orderDO);
    }

    @Override
    public UserDTO byUserId(String userId) {
        UserDAO userDAO = userDAOMapper.selectByPrimaryKey(userId);
        if (userDAO == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        UserDTO userDTO = UserConvert.UserDAO2UserDTO(userDAO);
        return userDTO;
    }

    @Override
    public void userCharge(String username, Double amount) {
        UserDAO user = new UserDAO();
        user.setUsername(username);
        UserDAO userDAO = userDAOMapper.selectByUserName(user);
        if (userDAO == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        if (amount < 0)
            throw new DragonException(20019, "金额不合法");
        double d = userDAO.getMoney() + amount;
        userDAO.setMoney(d);
        userDAOMapper.updateByPrimaryKeySelective(userDAO);
    }

    @Override
    public List<OrderDO> byUsernameOrder(String username) {
       return orderDOMapper.byUsernameOrder(username);
    }

    @Override
    public void modifyMoney(String username, Double money) {
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(username);
        UserDAO user = userDAOMapper.selectByUserName(userDAO);
        if(user == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        if(money>user.getMoney())
            throw new  DragonException(20078,"无法支付，余额不足");
        Double amount = user.getMoney()-money;
        Double d  = (double) Math.round(amount * 100) / 100;
        user.setMoney(d);
        userDAOMapper.updateByPrimaryKeySelective(user);
    }
}
