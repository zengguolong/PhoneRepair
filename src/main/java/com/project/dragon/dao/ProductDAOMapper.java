package com.project.dragon.dao;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.ProductDAO;

import java.util.List;

public interface ProductDAOMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductDAO record);

    int insertSelective(ProductDAO record);

    ProductDAO selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(ProductDAO record);

    int updateByPrimaryKey(ProductDAO record);

    List<ProductDAO> queryAllProduct();

    List<ProductDAO> byProductName(String productName);

    List<ProductDAO> byProductType(String productType);
}