package com.atguigu.spring.controller;

import com.atguigu.spring.Service.Impl.UserServiceImpl;
import com.atguigu.spring.Service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.saveUser();
    }
}
