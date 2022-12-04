package com.atguigu.spring.dao.Impl;

import com.atguigu.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
