package com.kingyal.usemybatis.daotemp;

import com.kingyal.usemybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 不使用xml文件，通过注解实现sql语句，但是依旧要到config文件中注册
 */
public interface UserDaoAnnotation {
    @Select("select id,username,password,gender,regist_time as resistTime from t_user")
    List<User> queryAllUsers();
    @Select("select id,username,password,gender,regist_time as resistTime from t_user " +
            "where id=#{param1}")
    User queryUserId(Integer id);
    @Options(useGeneratedKeys = true, keyProperty = "id") // 主键自增设置
    @Insert("insert into t_user values(#{id},#{username},#{password},#{gender},#{resistTime})")
    Integer insertUser(User user);
    @Update("update t_user\n" +
            "        set username=#{username},password=#{password},gender=#{gender},regist_time=#{resistTime}\n" +
            "        where id=#{id}")
    Integer updateUser(User user);
    @Delete("delete from t_user\n" +
            "        where id=#{id}")
    Integer deleteUserById(@Param("id") Integer id);
}
