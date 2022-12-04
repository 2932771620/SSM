package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.user;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class parameterTest {
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user root = mapper.getUserByUsername("root");
        System.out.println(root);
        sqlSession.close();
    }
    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user root = mapper.checkLogin("root","123");
        System.out.println(root);
        sqlSession.close();
    }
    @Test
    public void testCheckLoginMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","root");
        map.put("password","123");
        user root = mapper.checkLoginByMap(map);
        System.out.println(root);
        sqlSession.close();
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user user=new user(null,"sdaa","123456",33,"男","34567@qq.com");
        mapper.insertUser(user);
        sqlSession.close();
    }
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user root = mapper.checkLoginByParam("sdaa","123456");
        System.out.println(root);
        sqlSession.close();
    }
}
