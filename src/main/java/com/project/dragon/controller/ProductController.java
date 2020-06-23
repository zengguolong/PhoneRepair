package com.project.dragon.controller;

import com.github.pagehelper.PageInfo;
import com.project.dragon.converter.ProductConvert;
import com.project.dragon.dataobject.ProductDAO;
import com.project.dragon.dto.ProductDTO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.ProductService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ProductVO;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dragon/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //查询所有手机产品信息
    @GetMapping("/list")
    public ResultVO list() {
        List<ProductDTO> productDTOList = productService.queryAllProduct();
        List<ProductVO> productVOList = ProductConvert.productDTOList2ProductVOList(productDTOList);
        return ResultVOUtils.success(productVOList);
    }

    //分页查询手机产品信息
    @GetMapping("/pageQueryProduct")
    public ResultVO pages(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "8") Integer size) {
        PageInfo<ProductDTO> pageInfo = productService.queryAll(page, size);
        return ResultVOUtils.success(pageInfo);
    }


    //通过id查询手机产品信息
    @GetMapping("byId")
    public ResultVO byId(@RequestParam("productId") String productId) {

        ProductDAO productDAO = productService.byIdQueryProduct(productId);
        if (productDAO == null)
            throw new DragonException(ResultEnum.PRODUCT_NOT_EXIST);
        ProductDTO productDTO = ProductConvert.productDAO2ProductDTO(productDAO);
        ResultVO resultVO = new ResultVO();
        resultVO.setData(productDTO);
        resultVO.setMessage("查询成功");
        resultVO.setCode(20000);
        return resultVO;
    }

    //添加一个手机产品信息
    @GetMapping("/add")
    public ResultVO add(@RequestParam("product_name") String productName,
                        @RequestParam("product_type") String productType,
                        @RequestParam("product_image") String productImage) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setProductId(KeyUtils.genUniqueKey());
        productDAO.setProductName(productName);
        productDAO.setProductType(productType);
        productDAO.setProductImage(productImage);
        productService.addProduct(productDAO);
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("增加成功");
        return resultVO;
    }


    //删除一个手机产品信息
    @GetMapping("/delete")
    public ResultVO delete(
            @RequestParam("productId") String productId) {
        ProductDAO productDAO = productService.byIdQueryProduct(productId);
        if (productDAO == null) {
            throw new DragonException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        productService.deletePhone(productDAO.getProductId());
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("删除成功");
        return resultVO;
    }

    //更新手机产品信息
    @GetMapping("/update")
    public ResultVO update(@RequestParam("product_name") String productName,
                           @RequestParam("product_type") String productType,
                           @RequestParam("product_image") String productImage,
                           @RequestParam("product_id") String productId) {
        ProductDAO productDAO = productService.byIdQueryProduct(productId);
        if (productDAO == null)
            throw new DragonException(ResultEnum.PRODUCT_NOT_EXIST);
        productDAO.setProductImage(productImage);
        productDAO.setProductType(productType);
        productDAO.setProductName(productName);
        productService.update(productDAO);

        /**更改手机价格管理的手机型号相对应
         ManagerDO managerDO = managerDOMapper.selectByProductId(productId);
         if(managerDO == null)
         throw new DragonException(ResultEnum.MANAGER_NOT_EXIST);
         managerDO.setPhoneType(productType);
         managerDOMapper.updateByPrimaryKey(managerDO);*/

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("修改成功");
        return resultVO;
    }

    //通过手机产品名称查询手机信息
    @GetMapping("/byProductName")
    public ResultVO byProductName(@RequestParam("product_name") String productName) {
        List<ProductDTO> productDTOList = productService.byProductName(productName);
        if (productDTOList.size() == 0)
            throw new DragonException(ResultEnum.PRODUCT_NOT_EXIST);
        List<ProductVO> productVOList = ProductConvert.productDTOList2ProductVOList(productDTOList);
        return ResultVOUtils.success(productVOList);
    }

    //通过手机产品类型模糊查询手机信息
    @GetMapping("/byProductType")
    public ResultVO byProductType(@RequestParam("product_type") String productType) {
        List<ProductDTO> productDTOList = productService.byProductType(productType);
        List<ProductVO> productVOList = ProductConvert.productDTOList2ProductVOList(productDTOList);
        return ResultVOUtils.success(productVOList);
    }
}
