package com.atgui.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.user;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //��ȡ���������ļ���������
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //��ȡSqlSessionFactoryBuilder����
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //��ȡSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //��ȡSql�ĻỰ����SqlSession,��MyBatis�ṩ�Ĳ������ݿ�Ķ���
        SqlSession sqlSession = sqlSessionFactory.openSession();//�����Զ��ύ����������true
        //��ȡUserMapper�Ĵ���ʵ����Ķ���
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //����mapper�ӿ��еķ�����ʵ������û���Ϣ�Ĺ���
        int result = mapper.insertUser();
        System.out.println(result);
        //�ύ����
        sqlSession.commit();
        //�ر�SqlSession
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }
    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        user userById = mapper.getUserById();
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<user> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }
}
