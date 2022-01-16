package com.kingyal.factorytest;

import com.kingyal.factorytest.dao.UserDao;
import org.junit.Test;

import java.io.IOException;

public class MyFactoryTest {
    @Test
    public void test1() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyFactory myFactory = new MyFactory("/bean.properties");
        UserDao userDao = (UserDao)myFactory.getBean("UserDao");
        userDao.deleteUser();
    }
}
