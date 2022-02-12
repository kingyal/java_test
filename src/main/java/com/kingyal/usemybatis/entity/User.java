package com.kingyal.usemybatis.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private boolean gender;
    private Date resistTime;

    public User() {
    }

    public User(Integer id, String username, String password, boolean gender, Date resistTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.resistTime = resistTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getResistTime() {
        return resistTime;
    }

    public void setResistTime(Date resistTime) {
        this.resistTime = resistTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", resistTime=" + resistTime +
                '}';
    }
}
