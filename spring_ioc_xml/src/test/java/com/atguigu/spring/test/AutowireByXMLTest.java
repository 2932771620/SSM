package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXMLTest {
    /**
     * 自动装配
     * 根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的属性赋值
     *
     * 自动装配的策略：
     * no,default:都表示不装配
     * byType:根据赋值的属性类型的值，在IOC容器在中匹配某个备案，为属性赋值
     * 注意;
     *  1.根据类型一个都找不到，此时不装配
     *  2.根据类型找到多个，此时会抛出异常NoUniqueBeanDefinitionException
     *  3.byName:将要赋值的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
     *  总结：当类型匹配的bean有多个时，此时可是使用byName自动装配
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController bean = ioc.getBean(UserController.class);
        bean.saveUser();
    }
}
