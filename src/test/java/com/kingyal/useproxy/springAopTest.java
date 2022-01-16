package com.kingyal.useproxy;

import com.kingyal.factorytest.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springAopTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context-advice.xml");
        UserService proxy = (UserService)context.getBean("userService");
        System.out.println("********** query user **********");
        proxy.queryUser(1);
        System.out.println("********** delete user **********");
        proxy.deleteUser(1);
        System.out.println("********** saver user **********");
        proxy.saverUser(1);
//        System.out.println("********** update user **********");
//        proxy.updateUser(1);
    }
}
