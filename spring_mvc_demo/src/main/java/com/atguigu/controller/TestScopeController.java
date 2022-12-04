package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 向域对象共享数据
 * 1.通过ModelAndView向请求域共享数据
 *   使用ModelAndView时，可以使用其Model功能向请求域共享数据
 *   使用view功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2.使用Model向请求域共享数据
 * 3.使用ModelMap向请求域共享数据
 * 4.使用Map向请求域共享数据
 * 5.Model和ModelMap和map的关系
 * 其实在底层，这些类型的形参最终都是通过BindingAwareModelMap创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 */

@Controller
public class TestScopeController {


    @RequestMapping("/test/mav")
    public ModelAndView testMav(){
        /**
         * ModelAndView包含Model和view的功能
         * Model：向请求域中共享数据
         * View：设置逻辑试图，实现页面跳转
         *
         */
        ModelAndView mav=new ModelAndView();
//        向请求域共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置逻辑试图
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/test/model")
    public String testModel(Model map){
        /**
         * ModelAndView包含Model和view的功能
         * Model：向请求域中共享数据
         * View：设置逻辑试图，实现页面跳转
         *
         */
        System.out.println(map.getClass().getName());
//        向请求域共享数据
        map.addAttribute("testRequestScope","hello,ModelAndView");
        //设置逻辑试图
        return "success";
    }
    @RequestMapping("/test/modelmap")
    public String testModelMap(ModelMap map){
        /**
         * ModelAndView包含Model和view的功能
         * Model：向请求域中共享数据
         * View：设置逻辑试图，实现页面跳转
         *
         */

        System.out.println(map.getClass().getName());
//        向请求域共享数据
        map.addAttribute("testRequestScope","hello,ModelAndView");
        //设置逻辑试图
        return "success";
    }
    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        /**
         * ModelAndView包含Model和view的功能
         * Model：向请求域中共享数据
         * View：设置逻辑试图，实现页面跳转
         *
         */

//        向请求域共享数据
        map.put("testRequestScope","hello,ModelAndView");
        //设置逻辑试图
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,Session");
        return "success";

    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication","hello,Application");
        return "success";

    }
}
