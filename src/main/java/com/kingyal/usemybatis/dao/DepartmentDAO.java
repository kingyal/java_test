package com.kingyal.usemybatis.dao;

import com.kingyal.usemybatis.entity.Department;

public interface DepartmentDAO {
    // 查询部门及其所有员工的信息
    Department queryDepartmentById(Integer id);
}
