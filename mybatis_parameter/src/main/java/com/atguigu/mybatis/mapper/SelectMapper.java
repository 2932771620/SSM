package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    //根据id查询用户信息
    user getUserById(@Param("id") Integer id);
    //查询所有的用户信息
    List<user> getAlluser();
    //查询用户的总数量
    Integer getCount();
    //根据id查询用户信息放置在map集合中
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    //查询所有的用户信息为map集合
//    List<Map<String,Object>> getAllUserToMap();

    /**
     * 1.将map接口的返回值设置为泛型为map的list集合
     * 2.添加注解    @MapKey("id")
     *          以id为值，以查询出的结果为大的map的键，然后进行返回
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}