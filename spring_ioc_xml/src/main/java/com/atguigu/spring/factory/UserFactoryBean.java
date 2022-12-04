package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean是一个接口，需要创建一个实现类
 * 其中三个方法
 * 1.getObject()：通过一个对象交给IOC容器进行管理
 * 2.getObjectType():设置所提供的对象类型
 * 3.isSingleton():是否单例
 *                 当我们把FactoryBean的实现类配置时，会将当前类中的getObject()所返回的对象交给IOC容器进行管理
 */

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

