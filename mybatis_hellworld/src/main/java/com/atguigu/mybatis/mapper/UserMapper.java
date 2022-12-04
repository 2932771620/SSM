package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;

import java.util.List;

public interface UserMapper {
    //实现添加功能的方法
    int insertUser();
    //实现更新操作
    void updateUser();
    //实现删除操作
    void deleteUser();
    //实现根据id查询一条数据
    user getUserById();
    //查询所有的用户信息
    List<user> getAllUser();
}
