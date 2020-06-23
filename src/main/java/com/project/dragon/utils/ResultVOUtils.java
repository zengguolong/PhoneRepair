package com.project.dragon.utils;

import com.project.dragon.viewobject.ResultVO;

public class ResultVOUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVo = new ResultVO();
        resultVo.setCode(20000);
        resultVo.setMessage("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
