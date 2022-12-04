package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "男");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        empByCondition.forEach(System.out::println);
    }
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", null, "男");
        List<Emp> empByCondition = mapper.getEmpByChose(emp);
        empByCondition.forEach(System.out::println);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明1", 20, "男");
        Emp emp2 = new Emp(null, "小明2", 20, "男");
        Emp emp3 = new Emp(null, "小明3", 20, "男");
        Emp emp4 = new Emp(null, "小明4", 20, "男");
        List<Emp> list= Arrays.asList(emp1,emp2,emp3,emp4);
        mapper.insertMoreEmp(list);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds=new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);
    }
}
