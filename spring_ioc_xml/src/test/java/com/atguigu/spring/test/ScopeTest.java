package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student bean = ioc.getBean(Student.class);
        Student bean1 = ioc.getBean(Student.class);
        System.out.println(bean1==bean);
    }
}
