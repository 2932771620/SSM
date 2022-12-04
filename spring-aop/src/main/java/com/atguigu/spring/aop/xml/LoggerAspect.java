package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**

 */

@Component
public class LoggerAspect {
    public void pointCut(){}


    public void beforeAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法"+signature.getName()+",参数"+ Arrays.toString(args));
    }
    public void afterAdviceMethod(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",执行完毕");
    }
    /*

     */
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",结果："+result);
    }
    /*

     */
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",异常通知："+ex);
    }

    /**
     *
     * @param joinPoint
     * @return
     */
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知-》前置通知");
            result=joinPoint.proceed();
            System.out.println("环绕通知-》返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-》前置通知");
        }finally {
            System.out.println("环绕通知-》后置通知");

        }
        return result;
    }
}
