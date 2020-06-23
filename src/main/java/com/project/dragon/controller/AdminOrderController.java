package com.project.dragon.controller;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.OrderService;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    //分页查询所有订单信息
    @GetMapping("/pageQueryOrders")
    public ResultVO pages(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "8") Integer size) {
        PageInfo<OrderDO> pageInfo = orderService.pageQueryOrder(page, size);
        return ResultVOUtils.success(pageInfo);
    }

    //删除订单信息
    @GetMapping("/delete")
    public ResultVO delete(@RequestParam("order_id") String orderId) {
        OrderDO orderDO = orderService.byIdOrder(orderId);
        if (orderDO == null)
            throw new DragonException(ResultEnum.ORDER_NOT_EXIST);
        orderService.deleteOrder(orderId);
        return ResultVOUtils.success("删除订单成功");
    }

    //更新订单信息
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResultVO update(@RequestParam("order_id") String orderId,
                           @RequestParam(value = "user_id",required = false) String userId,
                           @RequestParam("order_username") String orderUsername,
                           @RequestParam("order_amount") Double orderAmount,
                           @RequestParam("order_detail") String orderDetail,
                           @RequestParam("order_phone") String orderPhone,
                           @RequestParam("order_status") String orderStatus,
                           @RequestParam("order_remark") String orderRemark) {
        OrderDO orderDO = orderService.byIdOrder(orderId);
        if (orderDO == null)
            throw new DragonException(ResultEnum.ORDER_NOT_EXIST);
        orderDO.setUserId(userId);
        orderDO.setOrderPhone(orderPhone);
        orderDO.setOrderAmount(orderAmount);
        orderDO.setOrderUsername(orderUsername);
        orderDO.setOrderDetail(orderDetail);
        orderDO.setOrderStatus(orderStatus);
        orderDO.setOrderRemark(orderRemark);
        orderService.updateOrder(orderDO);
        return ResultVOUtils.success("更改成功");
    }

    //根据订单id查询订单信息
    @GetMapping("/byId")
    public ResultVO byId(@RequestParam("order_id") String orderId) {
        OrderDO orderDO = orderService.byIdOrder(orderId);
        if (orderDO == null)
            throw new DragonException(ResultEnum.ORDER_NOT_EXIST);
        return ResultVOUtils.success(orderDO);
    }

    //完结订单
    @GetMapping("/finishOrder")
    public ResultVO finishOrder(@RequestParam("order_id") String orderId) {
        //查看该订单信息是否存在
        OrderDO orderDO = orderService.byIdOrder(orderId);
        if (orderDO == null)
            throw new DragonException(ResultEnum.ORDER_NOT_EXIST);
        //如果该订单状态不为0 则无法完结订单
        if (!orderDO.getOrderStatus().equals("0"))
            throw new DragonException(ResultEnum.ORDER_STATUS);

        orderDO.setOrderStatus("2");
        orderService.finishOrder(orderDO);
        return ResultVOUtils.success("完结成功");
    }

    //根据订单状态查询订单列表
    @GetMapping("/byOrderStatus")
    public ResultVO byOrderStatus(@RequestParam(value = "order_status", required = false) String orderStatus,
                                  @RequestParam(value = "order_username", required = false) String orderUsername) {
        List<OrderDO> orderDOList = orderService.byOrderStatus(orderStatus, orderUsername);
        return ResultVOUtils.success(orderDOList);
    }

    //根据用户id查询该用户的所有订单
    @GetMapping("/byUserId")
    public ResultVO byUserId(@RequestParam("user_id") String userId,
                             @RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "8") Integer size) {
        PageInfo<OrderDO> pageInfo = orderService.QueryUserAllOrder(userId, page, size);
        return ResultVOUtils.success(pageInfo);
    }

}
