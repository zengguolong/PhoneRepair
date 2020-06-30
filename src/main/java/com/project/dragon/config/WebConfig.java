package com.project.dragon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径  path为获取当前项目存放静态资源文件夹的目录
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";
        //     /images/**是对应resource下工程目录 （也就是静态资源存放文件路径）
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path);
    }
    /**
     * addResourceHandler()里配置需要映射的文件夹，此处代表映射文件夹user下的所有资源。
     * addResourceLocations()配置文件夹在系统中的路径，使用绝对路径，格式为“file:你的路径”
     */
}
