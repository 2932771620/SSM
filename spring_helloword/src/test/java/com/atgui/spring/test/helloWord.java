package com.atgui.spring.test;

import com.atguigu.spring.pojo.HelloWord;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class helloWord {
    @Test
    public void test1(){
        //获取IOC容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器里的bean对象
        HelloWord helloword = (HelloWord)ioc.getBean("helloword");
        helloword.sayHello();
    }
}
