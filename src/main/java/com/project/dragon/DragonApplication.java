package com.project.dragon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.project.dragon.dao")
public class DragonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DragonApplication.class, args);
    }

    //测试2
}
