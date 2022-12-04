package com.atguigu.spring.Service.Impl;

import com.atguigu.spring.Service.UserService;
import com.atguigu.spring.dao.UserDao;
import com.sun.management.UnixOperatingSystemMXBean;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
