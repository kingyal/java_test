package com.kingyal.usemybatis.dao;

import com.kingyal.usemybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User queryUserIdByMap(Integer id);
    User queryUserId(Integer id);
    User queryUserByIdAndUsername(Integer id, String name);
    User queryUserByIdAndPasswd(@Param("id") Integer id, @Param("password")String password);
    User queryUserByMapIdAndPasswd(Map map);
    User queryUserByUserIdAndPasswd(User user);
    List<User> queryUsersBUsername(@Param("name") String name);
    Integer deleteUserById(@Param("id") Integer id);
    Integer updateUser(User user);
    Integer insertUser(User user);
    // 主键回填
    Integer insertUserReturnKey(User user);
}
