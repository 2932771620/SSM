package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        //获取核心配置文件
        InputStream is= null;
        SqlSession sqlSession=null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取Sql的会话对象SqlSession,是MyBatis提供的操作数据库的对象
            sqlSession = sqlSessionFactory.openSession(true);//不会自动提交，除非设置true
        } catch (IOException e) {
            e.printStackTrace();
        }
       return sqlSession;
    }
}
