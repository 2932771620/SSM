package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.util.Arrays;

/**
在切面中可以通过指定的注解将方法标识为通知
 @before：前置通知，在执行之前执行
 @After:后置通知，在目标方法的finally字句中执行
 @AfterReturning:返回通知，在目标对象方法返回值之后执行
 @AfterThrowing：异常通知，在目标对象方法的catch方法中执行


 切入点表达式：设置在标识通知的注解的value属性中
 @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 第一个*表示任意访问修饰符和返回值类型
 第二个*表示当前类中的任意方法
 ..表示任意的参数列表
 类的地方也可以写*，表示包下所有的类

 重用切入点表达式
 设置公共点表达式
 @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
 public void pointCut(){}


 获取连接点的信息
 在通知方法的参数位置，设置JoinPoint类型的参数，就可以来获取连接点所对应的方法信息

 设置优先级
 @Order(value = 1)//数值越小，优先级越高
 */

@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}


//    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息
        Signature signature = joinPoint.getSignature();

        //获取连接点对应的方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法"+signature.getName()+",参数"+ Arrays.toString(args));
    }
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",执行完毕");
    }
    /*
    在返回通知中若要获取目标对象方法的返回值
    只需要通过@AfterReturning注解的returning属性值
    就可以将通知方法的某个参数指令为为接收目标对象方法的返回值的参数
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",结果："+result);
    }
    /*
    在返回通知中若要获取目标对象方法的返回值
    只需要通过@AfterThrowing注解的Throwing属性值
    就可以将通知方法的某个参数指令为为接收目标对象方法出出现的异常参数
     */
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){

        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法"+signature.getName()+",异常通知："+ex);
    }

    /**
     * 环绕通知的返回值和目标对像的返回值一致
     * @param joinPoint
     * @return
     */
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        //表示目标对象方法的执行
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
