package com.atguigu.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void test1() throws SQLException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("Spring-datasourse.xml");
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean.getConnection());
    }
}
