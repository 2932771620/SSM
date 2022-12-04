package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = ioc.getBean(UserController.class);
    }
}
