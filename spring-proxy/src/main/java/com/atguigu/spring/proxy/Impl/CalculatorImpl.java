package com.atguigu.spring.proxy.Impl;

import com.atguigu.spring.proxy.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法add，参数："+i+","+j);
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        System.out.println("日志，方法add，结果："+result);
        return result;
    }
    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法sub，参数："+i+","+j);

        int result = i - j;
        System.out.println("方法内部 result = " + result);
        System.out.println("日志，方法sub，结果："+result);

        return result;
    }
    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法mul，参数："+i+","+j);

        int result = i * j;
        System.out.println("方法内部 result = " + result);
        System.out.println("日志，方法mul，结果："+result);

        return result;
    }
    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法div，参数："+i+","+j);
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        System.out.println("日志，方法div，结果："+result);
        return result;
    }

}
