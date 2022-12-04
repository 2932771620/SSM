package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * mybatis获取参数值的两种方式:#{}和${}
 *     1.mapper接口的方法参数为单个的字面量类型
 *      此时可以用#{}和${}以任意的内容获取参数值,但更希望内容有意义,不过${}需要加''(如果是字符串)
 *     2.若mapper接口方法的参数为多个的字面量类型
 *       此时mybatis将数据放在map集合中,以arg1,arg0.....为键,以参数为值
 *                                 以param1,param2.....为键,以参数为值
 *             因此我们只需要通过#{}和${}访问map集合的键来获取参数值
 *     3.若mapper接口方法的参数为map集合类型的参数
 *     我们只需要通过#{}和${}访问map集合的键来获取参数值
 *     可以在mapper接口的方法上的参数上设置@param注解
 */
public interface UserMapper {
    //验证登录
    user checkLogin(String name,String password);
    //查询指定名字的用户信息
    user getUserByUsername(String username);
    //以map集合作为参数
    user checkLoginByMap(Map<String,Object> map);
    //添加用户
    void insertUser(user user);

    //验证登录，用@param注解
    user checkLoginByParam(@Param("username") String username, @Param("password") String password);


}
