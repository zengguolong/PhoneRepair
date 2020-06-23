package com.project.dragon.converter;

import com.project.dragon.dataobject.ProductDAO;
import com.project.dragon.dto.ProductDTO;
import com.project.dragon.viewobject.ProductVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ProductConvert {

    public static ProductVO productDTO2ProductVO(ProductDTO productDTO){
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(productDTO,productVO);
        return productVO;
    }

    public static List<ProductVO> productDTOList2ProductVOList(List<ProductDTO> productDTOList){
        return productDTOList.stream().map(e -> productDTO2ProductVO(e)).collect(Collectors.toList());
    }

    public static ProductDTO productDAO2ProductDTO(ProductDAO productDAO){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productDAO,productDTO);
        return productDTO;
    }

    public static List<ProductDTO> productDAOList2ProductDTOList(List<ProductDAO> productDAOList){
        return productDAOList.stream().map(e -> productDAO2ProductDTO(e)).collect(Collectors.toList());
    }
}
