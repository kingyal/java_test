package com.kingyal.usemybatis.dao;

import com.kingyal.usemybatis.entity.Passenger;

public interface PassengerDAO {
    // 通过旅客的id,查询旅客信息及其护照信息，关联查询，级联查询
    Passenger queryPassengerById(Integer id);
}
