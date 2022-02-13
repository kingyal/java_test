package com.kingyal.usemybatis.dao;

import com.kingyal.usemybatis.entity.Employee;

public interface EmployeeDAO {
    Employee queryEmployeeById(Integer id);
}
