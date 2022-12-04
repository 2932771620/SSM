package com.atguigu.controller;


import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * 查询所有的用户信息-->/employee-->get
 * 跳转到添加页面--->/to/add-->get
 * 新增员工信息-->/employee-->post
 * 跳转到修改页面--->/to/add-->get
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> all = employeeDao.getAll();
//        将所有的员工信息在请求域共享
        model.addAttribute("all",all);
//        for (Employee employee:all){
//
//        }
        //跳转到页面
        return "employee_list";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能（重定向列表功能）/employee
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee",employee);
        //跳转到employee_update
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //修改员工信息
        employeeDao.save(employee);
        //访问列表功能（重定向列表功能）/employee
        return "redirect:/employee";
    }
}
