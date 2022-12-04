package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {


    @RequestMapping("/")
    public String protal(){
        //将逻辑试图返回
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
