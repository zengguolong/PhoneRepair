package com.project.dragon.service;

import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.viewobject.BusinessVO;

public interface BusinessService {

    //查询营业信息
    BusinessDO query();

    //修改营业信息
    void updateBusiness(BusinessDO businessDO);

    //查询统计所有订单量和 所有营业金额
    BusinessVO queryAllBusiness();

}
