package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {
    //通过用户名模糊查询用户信息
    List<user> getUserByLike(@Param("mohu") String mohu);
    //删特定id,批量删除
    void deleteMoreUser(@Param("ids") String ids);
    //动态设置表名
    List<user> getUserList(@Param("tableName") String tablename);
    //添加用户信息，并获取自增的主键
    void insertUser(user user);
}
