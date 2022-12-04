package com.atguigu.spring.test;

import com.atguigu.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Collector;

public class test1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,2);
    }
}
