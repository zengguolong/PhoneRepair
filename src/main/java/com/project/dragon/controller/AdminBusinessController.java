package com.project.dragon.controller;

import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.BusinessService;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.BusinessVO;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class AdminBusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/query")
    public ResultVO queryBusiness() {
        BusinessDO businessDO = businessService.query();
        ResultVO resultVO = new ResultVO();
        if (businessDO == null)
            throw new DragonException(ResultEnum.QUERY_ERROR);
        resultVO.setData(businessDO);
        resultVO.setMessage("查询成功");
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        return resultVO;
    }


    @GetMapping("/update")
    public ResultVO updateBusiness(@RequestParam("order_number") Integer orderNumber,
                                   @RequestParam("amount") Double amount) {
        BusinessDO businessDO = businessService.query();
        if (businessDO == null)
            throw new DragonException(ResultEnum.UPDATE_ERROR);
        businessDO.setAmount(amount);
        businessDO.setOrderNumber(orderNumber);
        businessService.updateBusiness(businessDO);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("更改成功");
        return resultVO;
    }

    //查询统计所有订单量和 所有营业金额接口
    @PostMapping("/queryAllBusiness")
    public ResultVO<BusinessVO> queryAllBusiness() {
        BusinessVO businessVO = businessService.queryAllBusiness();
        return ResultVOUtils.success(businessVO);
    }
}
