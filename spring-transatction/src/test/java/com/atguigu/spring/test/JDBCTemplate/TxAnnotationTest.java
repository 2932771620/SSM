package com.atguigu.spring.test.JDBCTemplate;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 1.在spring中的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 *   在需要在事务管理的方法上加上@Transactional注解，就可以被事务管理
 *       @Transactional
 *       1.可以标识在方法上
 *       2.可以标识在类上，类上所有的方法都可以被管理
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
//        bookController.buyBook(1,1);
        bookController.checkout(1,new Integer[]{1,2});
    }

}
