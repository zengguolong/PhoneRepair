package com.project.dragon.converter;


import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.viewobject.OrderVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConvert {

    public static OrderVO orderDTO2orderVO(OrderDO orderDO){
        OrderVO orderVo = new OrderVO();
        BeanUtils.copyProperties(orderDO,orderVo);
        return orderVo;
    }

    public static List<OrderVO> orderDTOList2orderVOList(List<OrderDO> orderDOList){
        return orderDOList.stream().map(e -> orderDTO2orderVO(e)).collect(Collectors.toList());
    }
}
