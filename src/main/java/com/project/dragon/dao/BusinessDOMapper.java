package com.project.dragon.dao;

import com.project.dragon.dataobject.BusinessDO;
import com.project.dragon.viewobject.BusinessVO;
import org.springframework.stereotype.Repository;

public interface BusinessDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(BusinessDO record);

    int insertSelective(BusinessDO record);

    BusinessDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BusinessDO record);

    int updateByPrimaryKey(BusinessDO record);

    BusinessDO query();

}