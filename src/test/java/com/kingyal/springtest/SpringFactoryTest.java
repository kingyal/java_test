package com.kingyal.springtest;

import com.kingyal.factorytest.service.UserService;
import com.kingyal.usespring.constructinjection.Student;
import com.kingyal.usespring.factorybean.MyConnectionFactoryBean;
import com.kingyal.usespring.setinjection.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpringFactoryTest {
    @Test
    public void teest1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        UserService userDao = (UserService)context.getBean("UserService");
        userDao.deleteUser(520);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        User user = (User)context.getBean("User");
        System.out.println(user.toString());
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Student student = (Student)context.getBean("Student");
        System.out.println(student.toString());
    }
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        User user = (User)context.getBean("User");
        User user1 = (User)context.getBean("User");
        User user2 = (User)context.getBean("User");
        System.out.println(user == user1);
        System.out.println(user == user2);
    }

    @Test
    public void test5() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        // 获得工厂bean本身
         MyConnectionFactoryBean myConnectionFactoryBean = (MyConnectionFactoryBean)context.getBean("&connection");
         System.out.println(myConnectionFactoryBean);
        // 获得具体的类
        Connection connection = (Connection)context.getBean("connection");
        System.out.println(connection);
        // 执行查询语句
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println(resultSet.getInt("Population"));
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context-tmp.xml");
        context.close();
    }
}
