package com.project.dragon.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dragon.converter.ProductConvert;
import com.project.dragon.dao.ProductDAOMapper;
import com.project.dragon.dataobject.ProductDAO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.dto.ProductDTO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAOMapper productDAOMapper;

    @Override
    public List<ProductDTO> queryAllProduct() {
      List<ProductDAO> productDAOList =  productDAOMapper.queryAllProduct();
      return   ProductConvert.productDAOList2ProductDTOList(productDAOList);
    }

    @Override
    public PageInfo<ProductDTO> queryAll(int page, int size) {
        PageHelper.startPage(page,size);
        List<ProductDAO> productDAOList = productDAOMapper.queryAllProduct();
        PageInfo<ProductDAO> productDAOPageInfo = new PageInfo<>(productDAOList);
        PageInfo<ProductDTO> dtoPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(productDAOPageInfo,dtoPageInfo);
        List<ProductDTO> productDTOList = ProductConvert.productDAOList2ProductDTOList(productDAOList);
        dtoPageInfo.setList(productDTOList);
        return dtoPageInfo;
    }

    @Override
    public ProductDAO byIdQueryProduct(String productId) {
       return   productDAOMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void addProduct(ProductDAO productDAO) {
        int i =  productDAOMapper.insertSelective(productDAO);
        if(i==0)
            throw new DragonException(ResultEnum.UPDATE_ERROR);

    }

    @Override
    public void deletePhone(String productId) {
        productDAOMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public void update(ProductDAO productDAO) {
        productDAOMapper.updateByPrimaryKey(productDAO);
    }

    @Override
    public List<ProductDTO> byProductName(String productName) {
        List<ProductDAO> productDAOList = productDAOMapper.byProductName(productName);
        List<ProductDTO> productDTOList = ProductConvert.productDAOList2ProductDTOList(productDAOList);
        return productDTOList;
    }

    @Override
    public List<ProductDTO> byProductType(String productType) {
        List<ProductDAO> productDAOList  = productDAOMapper.byProductType(productType);
        List<ProductDTO> productDTOList = ProductConvert.productDAOList2ProductDTOList(productDAOList);
        return productDTOList;
    }
}
