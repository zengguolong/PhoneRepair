package com.project.dragon.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtils {

    public final static String IMG_PATH_PREFIX = "static/images";

    public static File getImgDirFile(){
        // 构建上传文件的存放 “文件夹” 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return KeyUtils.genUniqueKey() + getSuffix(fileOriginName);
    }


    /**
     * @param file     文件
     * @param fileName 原文件名
     * @return
     */
    public static String upload(MultipartFile file, String fileName) {
        //生成新的文件名
        String newFileName = getFileName(fileName);
        // 存放上传图片的文件夹
        File fileDir = getImgDirFile();
        // 输出文件夹绝对路径 – 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());

        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFileName);
            System.out.println(newFile.getAbsolutePath());
            //保存文件
            file.transferTo(newFile);
            return newFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
