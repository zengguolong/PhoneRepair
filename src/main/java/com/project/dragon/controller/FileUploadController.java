package com.project.dragon.controller;

import com.project.dragon.dao.MyImagesDAOMapper;
import com.project.dragon.dataobject.MyImagesDAO;
import com.project.dragon.utils.FileUtils;
import com.project.dragon.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private MyImagesDAOMapper myImagesDAOMapper;

    @Value("${web.upload-path}")
    private String path;

    /**
     * @param file 上传的文件
     * @return 可访问的url图片路径
     */
    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file)  {
        //2获得文件名字
        String fileName = file.getOriginalFilename();
        //2上传失败提示
        String warning = "";
        String newFileName = FileUtils.upload(file, path, fileName);
        //把文件生成的图片url地址写入数据库
        String url = "http://106.13.32.8/file/" + newFileName;//百度云的服务器地址
        MyImagesDAO myImagesDAO = new MyImagesDAO();
        myImagesDAO.setId(KeyUtils.genUniqueKey());
        myImagesDAO.setMyimages(url);
        myImagesDAOMapper.insert(myImagesDAO);

        if (newFileName != null) {
            //上传成功
            warning = url;
        } else {
            warning = "上传失败";
        }
        System.out.println(warning);
        return warning;
    }

}
