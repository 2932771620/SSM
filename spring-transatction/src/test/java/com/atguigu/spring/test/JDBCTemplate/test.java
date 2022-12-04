package com.atguigu.spring.test.JDBCTemplate;


import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前的测试类在spring的测试环境下执行，此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbctemplate.xml")
public class test {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        String sql="insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"root","123",23,"女","123@qq.com");
    }


    @Test
    public void testGetUserById(){
        String sql="select * from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }
    @Test
    public void testGetUserAllUser(){
        String sql="select * from t_user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        query.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        String sql="select count(*)from t_user";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
