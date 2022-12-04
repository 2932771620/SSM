package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import com.atguigu.spring.aop.annotation.CalculatorImpl;
import com.atguigu.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.div(1,1);
    }
}
