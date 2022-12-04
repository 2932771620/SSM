package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;

public class IOCByXMLTest {
    /*
    后去bean的三种方式
    根据bean的类型来获取
       注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
       若一个都没有，则抛出NoSuchBeanDefinitionException
       若多个;则抛出：NoUniqueBeanDefinitionException

     */
    @Test
    public void test(){
        //获取Ioc容器
        ClassPathXmlApplicationContext IOC = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        Student student = (Student) IOC.getBean("studentOne");
//        Student bean = IOC.getBean(Student.class);
        Student studentOne = IOC.getBean("studentOne", Student.class);
        System.out.println(studentOne);


    }
    //set注入
    @Test
    public void test1(){
        //获取Ioc容器
        ClassPathXmlApplicationContext IOC = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        Student student = (Student) IOC.getBean("studentOne");
//        Student bean = IOC.getBean(Student.class);
        Student studentOne = IOC.getBean("student", Student.class);
        System.out.println(studentOne);


    }
    //构造器注入
    @Test
    public void test2(){
        //获取Ioc容器
        ClassPathXmlApplicationContext IOC = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
//        Student student = (Student) IOC.getBean("studentOne");
//        Student bean = IOC.getBean(Student.class);
        Student studentOne = IOC.getBean("studentFore", Student.class);
        System.out.println(studentOne);
//        Clazz classInner = IOC.getBean("classInner", Clazz.class);
//        System.out.println(classInner);
    }
}
