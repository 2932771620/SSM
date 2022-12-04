package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    ////    通过分布查询获得员工和对应的部门信息第二步
    Dept getEmpAndDeptByStepTwo(Integer deptId);
    //查询部门中所有的员工信息
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
//    通过分布查询部门以及部门中的员工信息的第一步
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

}
