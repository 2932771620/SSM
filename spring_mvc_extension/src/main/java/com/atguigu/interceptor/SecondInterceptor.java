package com.atguigu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器的三个方法
 * preHandle():在控制器方法执行之前执行，其返回值表示对控制器方法的拦截或放行
 * postHandle():在控制器方法执行后执行
 * afterCompletion():在控制器方法执行之后，且渲染完毕
 *
 * 多个拦截器的执行顺序
 * ①若每个拦截器的preHandle()都返回true
 * 此时多个拦截器的执行顺序和拦截器在SpringMVC的配置文件的配置顺序有关：
 * preHandle()会按照配置的顺序执行，而postHandle()和afterCompletion()会按照配置的反序执行
 * ②若某个拦截器的preHandle()返回了false
 * preHandle()返回false和它之前的拦截器的preHandle()都会执行，postHandle()都不执行，返回false
 * 的拦截器之前的拦截器的afterCompletion()会执行
 */
@Component
public class SecondInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("First");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
    }
}
