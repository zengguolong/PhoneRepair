package com.project.dragon.controller;

import com.project.dragon.dataobject.LabelDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.LabelService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    //查询所有手机标签
    @GetMapping("/list")
    public ResultVO list(){
        List<LabelDO> labelDOList = labelService.queryAll();
        return ResultVOUtils.success(labelDOList);
    }

    //添加手机标签
    @GetMapping("/add")
    public ResultVO add(@RequestParam("phone_type") String phoneType) {
        LabelDO label = labelService.byLabelType(phoneType);
        if(label!=null)
            throw new DragonException(ResultEnum.PHONE_LABEL_EXIST);
        LabelDO labelDO = new LabelDO();
        labelDO.setId(KeyUtils.genUniqueKey());
        labelDO.setPhoneLabel(phoneType);
        labelService.add(labelDO);
        return ResultVOUtils.success("添加成功");
    }

    //删除手机标签
    @GetMapping("/delete")
    public ResultVO delete(@RequestParam("id") String id){
        LabelDO label = labelService.byLabelId(id);
        if(label==null)
            throw new DragonException(ResultEnum.PHONE_LABEL_NOT_EXIST);
        labelService.delete(id);
        return ResultVOUtils.success("删除成功");
   }

   //更新手机标签
   @GetMapping("/update")
    public ResultVO update(@RequestParam("id") String id,
                           @RequestParam("phone_type") String phoneType){
       LabelDO label = labelService.byLabelId(id);
       if(label==null)
           throw new DragonException(ResultEnum.PHONE_LABEL_NOT_EXIST);
       label.setPhoneLabel(phoneType);
       labelService.update(label);
       return ResultVOUtils.success("修改成功");
   }

   //通过id查询手机标签
   @GetMapping("/byLabelId")
   public ResultVO byLabelId(@RequestParam("id")String id){
        LabelDO labelDO = labelService.byLabelId(id);
        if(labelDO==null)
            throw new DragonException(ResultEnum.PHONE_LABEL_NOT_EXIST);
        return ResultVOUtils.success(labelDO);
   }


}
