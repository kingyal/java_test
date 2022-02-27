package com.kingyal.usemybatis.service;

import com.github.pagehelper.PageInfo;
import com.kingyal.usemybatis.entity.Page;
import com.kingyal.usemybatis.entity.User;

public interface UserService {
    // 分页查询service
    PageInfo<User> queryUsers(Page page);
}
