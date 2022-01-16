package com.kingyal.factorytest.service;

import com.kingyal.factorytest.dao.UserDao;
import com.kingyal.factorytest.dao.UserDaoImpl;
import com.kingyal.usespring.setinjection.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public List<User> queryUser(Integer id) {
        System.out.println("query user, user id : " + id);
        return new ArrayList<User>();
    }

    public Integer updateUser(Integer id) {
        System.out.println("update user");
        throw new NullPointerException("test 空指针");
        // return 1;
    }

    public Integer saverUser(Integer id) {
        System.out.println("save user");
        return 1;
    }

    public Integer deleteUser(Integer id) {
        userDao.deleteUser();
        System.out.println("after userDao delete , delete User in Service, User id : " + id);
        return 1;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
