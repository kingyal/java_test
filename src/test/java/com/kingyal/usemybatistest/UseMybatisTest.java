package com.kingyal.usemybatistest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingyal.usemybatis.dao.*;
import com.kingyal.usemybatis.daotemp.UserDaoAnnotation;
import com.kingyal.usemybatis.entity.*;
import com.kingyal.usemybatis.util.MyBatisUtil;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UseMybatisTest {
    @Test
    public void test1() throws IOException {
         // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlsession获取DAO创建类的对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 查询数据
        System.out.println("=================user0=================");
        User user0 = userDao.queryUserIdByMap(1);
        System.out.println(user0);
        System.out.println("=================user1=================");
        User user1 = userDao.queryUserId(1);
        System.out.println(user1);
        System.out.println("=================user2=================");
        User user2 = userDao.queryUserByIdAndUsername(1, "tony");
        System.out.println(user2);
        System.out.println("=================user3=================");
        User user3 = userDao.queryUserByIdAndPasswd(1, "tony_0");
        System.out.println(user3);
        System.out.println("=================user4=================");
        Map map = new HashMap();
        map.put("id", 2);
        map.put("passwd", "shine_0");
        User user4 = userDao.queryUserByMapIdAndPasswd(map);
        System.out.println(user4);
        System.out.println("=================user5=================");
        User userTmp = new User();
        userTmp.setId(2);
        userTmp.setPassword("shine_0");
        User user5 = userDao.queryUserByUserIdAndPasswd(userTmp);
        System.out.println(user5);
        System.out.println("=================user6=================");
        List<User> users = userDao.queryUsersBUsername("shi");
        System.out.println(users);
        System.out.println("=================delete=================");
        System.out.println(userDao.deleteUserById(1));
        sqlSession.commit();
        System.out.println("=================update=================");
        User user7 = new User();
        user7.setId(5);
        user7.setUsername("tony");
        user7.setPassword("tony_0");
        user7.setGender(true);
        user7.setResistTime(new Date());
        System.out.println(userDao.updateUser(user7));
        sqlSession.commit();
        System.out.println("=================insert=================");
        User user8 = new User(1, "mary", "mary_0", false, new Date());
        System.out.println(userDao.insertUser(user8));
        sqlSession.commit();
        System.out.println(user8);
        System.out.println("=================主键回填=================");
        // 主键回填，将新数据的id，存入java对象和主键对应的属性中
        User user9 = new User(null, "mary1", "mary_1", false, new Date());
        System.out.println(userDao.insertUserReturnKey(user9));
        sqlSession.commit();
        System.out.println(user9);
    }

    @Test
    public void test1_1() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user1 = new User();
        user1.setId(1);
        User queryUser1 = mapper.queryUser(user1);
        System.out.println(queryUser1.toString());
        User user2 = new User();
        user2.setUsername("mary");
        User queryUser2 = mapper.queryUser(user2);
        System.out.println(queryUser2.toString());
    }

    @Test
    public void test1_2() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user1 = new User();
        user1.setUsername("mary");
        List<User> users1 = mapper.queryUsers(user1);
        for(User user :users1) {
            System.out.println(user);
        }
        System.out.println("***********************************");
        User user2 = new User();
        user2.setUsername("mary");
        user2.setGender(true);
        List<User> users2 = mapper.queryUsers(user2);
        for(User user :users2) {
            System.out.println(user);
        }
        MyBatisUtil.commit();
    }

    @Test
    public void test1_3() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user2 = new User();
        user2.setUsername("mary");
        user2.setGender(true);
        List<User> users2 = mapper.queryUsers(user2);
        for(User user :users2) {
            System.out.println(user);
        }
        MyBatisUtil.commit();
    }

    @Test
    public void test1_4() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user1 = new User();
        user1.setId(1);
        User queryUser1 = mapper.queryUser(user1);
        System.out.println(queryUser1.toString());
        user1.setPassword("mary_1234");
        mapper.updateUserBySet(user1);
        User queryUser2 = mapper.queryUser(user1);
        System.out.println(queryUser2.toString());
        MyBatisUtil.commit();
    }

    @Test
    public void test1_5() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user1 = new User();
        user1.setId(2);
        User queryUser1 = mapper.queryUser(user1);
        System.out.println(queryUser1.toString());
        user1.setPassword("shine_1234");
        mapper.updateUserBySet(user1);
        User queryUser2 = mapper.queryUser(user1);
        System.out.println(queryUser2.toString());
        MyBatisUtil.commit();
    }

    @Test
    public void test1_6() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        User user1 = new User();
        List<Integer> lists = new ArrayList<Integer>();
        lists.add(9);
        lists.add(10);
        Integer integer = mapper.deleteUsersById(lists);
        System.out.println(integer);
        MyBatisUtil.commit();
    }

    @Test
    public void test2() throws IOException {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlsession获取DAO创建类的对象
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        // 查询数据
        System.out.println("=================student1=================");
        Student student1 = new Student(null, "tony", true);
        studentDao.insertStudent(student1);
        sqlSession.commit();
    }

    @Test
    public void test3() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        Student student = new Student("null", "XiaoMing", true);
        studentDao.insertStudent(student);
        MyBatisUtil.commit();
    }

    @Test
    public void test4() {
        PassengerDAO mapper = MyBatisUtil.getMapper(PassengerDAO.class);
        Passenger passenger = mapper.queryPassengerById(1);
        System.out.println(passenger.toString());
        System.out.println(passenger.getPassport().toString());
    }

    @Test
    public void test5() {
        DepartmentDAO mapper = MyBatisUtil.getMapper(DepartmentDAO.class);
        Department department = mapper.queryDepartmentById(1);
        System.out.println(department.toString());
        System.out.println(department.getEmployees());
    }

    @Test
    public void test6() {
        EmployeeDAO mapper = MyBatisUtil.getMapper(EmployeeDAO.class);
        Employee employee = mapper.queryEmployeeById(1);
        System.out.println(employee.toString());
        System.out.println(employee.getDepartment().toString());
    }

    @Test
    public void test7() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.queryUsers(new User());
        System.out.println("********************");
        mapper.queryUsers(new User());
        sqlSession.close();
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        SqlSession sqlSession1 = MyBatisUtil.getSession();
        SqlSession sqlSession2 = MyBatisUtil.getSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.queryUsers(new User());
        sqlSession.close();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        SqlSession sqlSession0 = MyBatisUtil.getSession();
        UserDao mapper0 = sqlSession0.getMapper(UserDao.class);
        mapper0.deleteUserById(1);
        sqlSession0.commit();
        sqlSession0.close();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        UserDao mapper1 = sqlSession1.getMapper(UserDao.class);
        mapper1.queryUsers(new User());
        sqlSession1.close();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        UserDao mapper2 = sqlSession2.getMapper(UserDao.class);
        mapper2.queryUsers(new User());
        sqlSession2.close();
    }

    @Test
    public void test9() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        // 在查询前，设置分页，这里查询第一页，每页2条数据,PageHelper对其之后的第一个查询，进行分页功能的追加
        PageHelper.startPage(1,2);
        List<User> users = mapper.queryUsers(new User());
        for (User user : users) {
            System.out.println(user);
        }
        // 可以将查询接结果封装到PageInfo对象中，便于以后使用
        PageInfo<User> pageInfo = new PageInfo<User>(users);
    }

    @Test
    public void test10() {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        // 在查询前，设置分页，这里查询第一页，每页2条数据,PageHelper对其之后的第一个查询，进行分页功能的追加
        PageHelper.startPage(1,2);
        List<User> users = mapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        // 可以将查询接结果封装到PageInfo对象中，便于以后使用
        PageInfo<User> pageInfo = new PageInfo<User>(users);
    }

    @Test
    public void test11() {
        UserDaoAnnotation mapper = MyBatisUtil.getMapper(UserDaoAnnotation.class);
        List<User> users = mapper.queryAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test12() {
        UserDaoAnnotation mapper = MyBatisUtil.getMapper(UserDaoAnnotation.class);
        System.out.println("**********query**********");
        User user1 = mapper.queryUserId(2);
        System.out.println(user1);
        System.out.println("**********delete**********");
        mapper.deleteUserById(2);
        user1 = mapper.queryUserId(2);
        System.out.println(user1);
        System.out.println("**********insert**********");
        Integer user_temp = mapper.insertUser(new User(2, "user_temp", "temp_000", true, new Date()));
        user1 = mapper.queryUserId(2);
        System.out.println(user1);
        System.out.println("**********update**********");
        mapper.updateUser(new User(2, "user_temp_1", "temp_111", true, new Date()));
        user1 = mapper.queryUserId(2);
        System.out.println(user1);
        MyBatisUtil.commit();
    }
}
