package com.project.dragon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public void setRedis(){
        //第一个参数key 第二个参数value 第三个参数过期时间 第四个参数时间单位（秒）
        stringRedisTemplate.opsForValue().set("abc","123456",7200, TimeUnit.SECONDS);
    }
}
