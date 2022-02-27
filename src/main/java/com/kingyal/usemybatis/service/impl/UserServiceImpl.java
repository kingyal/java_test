package com.kingyal.usemybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingyal.usemybatis.dao.UserDao;
import com.kingyal.usemybatis.entity.Page;
import com.kingyal.usemybatis.entity.User;
import com.kingyal.usemybatis.service.UserService;
import com.kingyal.usemybatis.util.MyBatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    public PageInfo<User> queryUsers(Page page) {
        UserDao mapper = MyBatisUtil.getMapper(UserDao.class);
        // 在查询前，设置分页，这里查询第一页，每页2条数据,PageHelper对其之后的第一个查询，进行分页功能的追加
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> users = mapper.queryAllUser();
        // 可以将查询接结果封装到PageInfo对象中，便于以后使用
        return new PageInfo<User>(users);
    }
}
