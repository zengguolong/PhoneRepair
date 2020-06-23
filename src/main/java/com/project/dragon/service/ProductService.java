package com.project.dragon.service;

import com.github.pagehelper.PageInfo;
import com.project.dragon.dataobject.ProductDAO;
import com.project.dragon.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    //查询所有商品
    List<ProductDTO> queryAllProduct();

    //分页查询所有商品
    PageInfo<ProductDTO> queryAll(int page,int size);

    //根据id查询商品信息
    ProductDAO byIdQueryProduct(String productId);

    //添加一个手机产品信息
    void addProduct(ProductDAO productDAO);

    //删除一个手机产品信息
    void deletePhone(String productId);

    //修改一个手机信息
    void update(ProductDAO productDAO);

    //通过手机品牌查询手机产品信息
    List<ProductDTO> byProductName(String productName);

    //通过手机类型对手机产品信息进行模糊查询
    List<ProductDTO> byProductType(String productType);
}
