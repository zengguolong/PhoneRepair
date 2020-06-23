package com.project.dragon.converter;

import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.dto.UserDTO;
import com.project.dragon.viewobject.UserVO;
import org.springframework.beans.BeanUtils;

public class UserConvert {

    public static UserDTO UserDAO2UserDTO(UserDAO userDAO){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDAO,userDTO);
        return userDTO;
    }

    public static UserVO UserDTO2UserVO(UserDTO userDTO){
       UserVO userVO = new UserVO();
       BeanUtils.copyProperties(userDTO,userVO);
       return userVO;
    }
}
