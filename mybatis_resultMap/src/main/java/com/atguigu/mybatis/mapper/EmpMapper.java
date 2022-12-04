package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    //根据id
    Emp getEmpByEmpId(@Param("empId") Integer empId);
//    获取员工以及对应的部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
//    通过分布查询获得员工和对应的部门信息
    Emp getEmpAndDeptByStep(@Param("empId") Integer empId);

    //
    List<Emp> getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
}
