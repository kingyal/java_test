package com.kingyal.factorytest.service;

import com.kingyal.factorytest.dao.UserDao;
import com.kingyal.factorytest.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
        System.out.println("after userDao delete , delete User in Service, User id : " + id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
