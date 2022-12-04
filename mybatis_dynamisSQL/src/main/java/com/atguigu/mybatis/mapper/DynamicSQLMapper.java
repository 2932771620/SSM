package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    List<Emp> getEmpByCondition(Emp emp);
    //查询员工信息
    List<Emp> getEmpByChose(Emp emp);
    //批量添加员工信息
    void insertMoreEmp(@Param("emps") List<Emp> emps);
    //批量删除员工信息
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
