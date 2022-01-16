package com.kingyal.factorytest.service;

import com.kingyal.usespring.setinjection.User;

import java.util.List;

public interface UserService {
    public List<User> queryUser(Integer id);
    public Integer updateUser(Integer id);
    public Integer saverUser(Integer id);
    public Integer deleteUser(Integer id);
}
