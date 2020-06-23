package com.project.dragon.controller;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.ManagerDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.ManagerService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class AdminManagerController {

    @Autowired
    private ManagerService managerService;

    //查询所有维修手机价格信息
    @GetMapping("/list")
    public ResultVO list() {
        List<ManagerDO> managerDOList = managerService.queryAll();
        return ResultVOUtils.success(managerDOList);
    }

    //分页查询手机维修价格信息
    @GetMapping("/pageQueryManagers")
    public ResultVO pages(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "8") Integer size) {
        PageInfo<ManagerDO> pageInfo = managerService.pageQueryManager(page, size);
        return ResultVOUtils.success(pageInfo);
    }


    //添加一个手机维修价格信息
    @GetMapping("/add")
    public ResultVO add(@RequestParam("phone_type") String phone_type,
                        @RequestParam("message") String message,
                        @RequestParam("price") Double price) {
        ManagerDO managerDO = new ManagerDO();
        managerDO.setId(KeyUtils.genUniqueKey());
        managerDO.setMessage(message);
        managerDO.setPhoneType(phone_type);
        managerDO.setPrice(price);
        managerService.add(managerDO);
        return ResultVOUtils.success("添加维修信息成功");
    }

    //添加多个手机维修价格信息
    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    public ResultVO adds(@RequestBody List<ManagerDO> managerDOList) {
        managerService.adds(managerDOList);
        return ResultVOUtils.success("添加所有维修信息成功");
    }

    //删除一个手机价格管理信息
    @GetMapping("/delete")
    public ResultVO delete(@RequestParam("id") String managerId) {
        //查看该管理信息是否存在
        ManagerDO managerDO = managerService.byManagerId(managerId);
        if (managerDO == null)
            throw new DragonException(ResultEnum.MANAGER_NOT_EXIST);
        managerService.delete(managerId);
        return ResultVOUtils.success();
    }

    //更新一个手机价格信息
    @GetMapping("/update")
    public ResultVO update(@RequestParam("id") String managerId,
                           @RequestParam("phone_type") String phone_type,
                           @RequestParam("message") String message,
                           @RequestParam("price") Double price) {
        //查看该管理信息是否存在
        ManagerDO managerDO = managerService.byManagerId(managerId);
        if (managerDO == null)
            throw new DragonException(ResultEnum.MANAGER_NOT_EXIST);
        managerDO.setPhoneType(phone_type);
        managerDO.setMessage(message);
        managerDO.setPrice(price);
        managerService.update(managerDO);
        return ResultVOUtils.success();
    }

    //通过id查询手机信息
    @GetMapping("/byId")
    public ResultVO byManagerId(@RequestParam("id") String managerId) {
        ManagerDO managerDO = managerService.byManagerId(managerId);
        if (managerDO == null)
            throw new DragonException(ResultEnum.MANAGER_NOT_EXIST);
        return ResultVOUtils.success(managerDO);
    }

    //通过手机型号查询手机价格管理信息
    @GetMapping("/byPhoneType")
    public ResultVO byPhoneType(@RequestParam("phone_type") String phone_type) {
        List<ManagerDO> managerDOList = managerService.byPhoneType(phone_type);
        if (managerDOList == null)
            throw new DragonException(ResultEnum.MANAGER_NOT_EXIST);
        return ResultVOUtils.success(managerDOList);
    }
}
