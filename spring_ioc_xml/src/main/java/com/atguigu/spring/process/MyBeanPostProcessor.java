package com.atguigu.spring.process;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //bean初始化之前进行执行
        System.out.println("☆☆☆" + beanName + " = " + bean);
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //bean初始化之后进行执行
        System.out.println("★★★" + beanName + " = " + bean);
        return bean;
    }
}
