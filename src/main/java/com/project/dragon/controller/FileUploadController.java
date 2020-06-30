package com.project.dragon.controller;

import com.project.dragon.dao.MyImagesDAOMapper;
import com.project.dragon.dataobject.MyImagesDAO;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.utils.UploadUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private MyImagesDAOMapper myImagesDAOMapper;


    /**
     * @param file 上传的文件
     * @return 可访问的url图片路径
     */
    @PostMapping("/fileUpload")
    public ResultVO upload(@RequestParam("file") MultipartFile file)  {
        //2获得文件名字
        String fileName = file.getOriginalFilename();
        //2上传失败提示
        String warning = "";
        String newFileName = UploadUtils.upload(file, fileName);
        //返回前端可访问的url地址,由于是本地暂时写死
        String url = "http://localhost:8080/images/" + newFileName;
        MyImagesDAO myImagesDAO = new MyImagesDAO();
        myImagesDAO.setId(KeyUtils.genUniqueKey());
        myImagesDAO.setMyimages(url);
        myImagesDAOMapper.insert(myImagesDAO);  //把文件生成的图片url地址写入数据库

        if (newFileName != null) {
            //上传成功
            warning = url;
        } else {
            warning = "上传失败";
        }
        System.out.println(warning);
        return ResultVOUtils.success(url);
    }

}
