package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 * 2.@RequestMapping注解的value属性
 * 作用：通过请求的请求路径匹配请求
 *      value属性是数组类型，即浏览器所发送的请求路径
 *      匹配value属性中的任何一个值，则当前请求就会被控制器方法(加注解)进行处理
 * 3.@RequestMapping注解的method属性
 * 作用：通过请求方式匹配请求
 *         method属性是数组类型，即浏览器所发送的请求路径
 *  *      匹配method属性中的任何一个值，则当前请求就会被控制器方法(加注解)进行处理
 *  若浏览器所发送的请求路径和@RequestMapping注解的value属性匹配，但请求方式不匹配
 *  则页面报错 405：Request method 'POST' not supported
 *  在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping，@PostMapping,@DeleteMapping,@PutMapping
 * @RequestMapping注解的params属性作用
 * @RequestMapping注解的params属性通过请求的请求参数匹配请求，即浏览器发送的请求参数必须满足
 * params属性到的设置
 * @RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数
 * 和请求映射的匹配关系
 * "param"：要求请求映射所匹配的请求必须携带param请求参数
 * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
 * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
 * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
 * 400: Parameter conditions "username" not met for actual request parameters
 * @RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
 * @RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信
 * 息和请求映射的匹配关系
 * "header"：要求请求映射所匹配的请求必须携带header请求头信息
 * "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
 * "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
 * "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
 * 若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面
 * 显示404错误，即资源未找到
 * 6.SpringMVC支持ant风格的路径
 * ？：表示任意的单个字符
 * *：表示任意的0个或多个字符
 * **：表示任意层数的任意目录
 * 注意：在使用**时，只能使用**写在双斜线中，不能有别的字符
 *
 * 7.SpringMVC支持路径中的占位符（重点）
 * 原始方式：/deleteUser?id=1
 * rest方式：/user/delete/1
 * 需要在@RequestMapping注解的value属性中设置的路径，使用{xxx}的方式表示路径中的数据
 * 在通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定
 */

@Controller
//@RequestMapping("/demo")
public class TestRequestMapping {


    //此时控制器方法匹配的请求的请求路径为test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET}
//            params = {"username","!password","age=20","gender!=女"}
//            headers = {"referer"}

    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a*a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id"+id);
        return "success";
    }

}
