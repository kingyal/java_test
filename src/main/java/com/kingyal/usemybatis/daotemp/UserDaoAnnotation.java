package com.kingyal.usemybatis.dao;

import com.kingyal.usemybatis.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 不使用xml文件，通过注解实现sql语句，但是依旧要到config文件中注册
 */
public interface UserDaoAnnotation {
    @Select("select id,username,password,gender,regist_time as resistTime from t_user")
    List<User> queryAllUsers();
}
