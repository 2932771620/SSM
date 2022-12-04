package com.atguigu.spring.test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    @Test
    public void testUserFactoryBean(){
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ac.getBean(User.class);
        System.out.println(user);
    }

}
