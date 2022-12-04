package com.atguigu.spring.test;

import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
    /*
    生命周期
    1.实例化
    2.依赖注入
    3.后置处理器的postProcessBeforeInitialization方法
    4.初始化 需要通过bean的init-method属性指定初始化的方法
    5.后置处理器的postProcessAfterInitialization方法
    6.IOC容器关闭时销毁 需要通过bean的destroy-method属性指定销毁的方法

    注意：当bean的作业域为单例，生命周期的前三个步骤会在获取IOC容器时执行
         当bean的作业域为多例，生命周期的前三个步骤会在获取bean时执行
    */
    @Test
    public void testLife(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ac.getBean(User.class);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用");
        ac.close();
    }
}
