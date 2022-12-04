package com.atguigugu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import com.atguigu.spring.proxy.Impl.CalculatorImpl;
import com.atguigu.spring.proxy.proxyFactory;
import org.junit.Test;

public class ProxyTest {
    /**
     * 动态代理
     * 1.jdk动态代理，必须要有接口，最终生成的代理类在com.sun.proxy包下，类名为$proxy2
     * 2.cglib动态代理 最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void test1(){
//        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);
        proxyFactory proxyFactory = new proxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.div(1, 1);

    }

}
