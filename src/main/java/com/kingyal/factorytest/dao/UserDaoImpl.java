package com.kingyal.factorytest.dao;

public class UserDaoImpl implements UserDao{
    public void deleteUser(Integer id) {
        System.out.println("delete User in Dao, User id : " + id);
    }
}
