package com.project.dragon.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/result")
    public String demo() {
        return "token";
    }

    @GetMapping("/info")
    public Map<String,String> userInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("code","20000");
        map.put("data","info");
        return map;
    }
}
