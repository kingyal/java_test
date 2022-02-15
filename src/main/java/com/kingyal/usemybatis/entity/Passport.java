package com.kingyal.usemybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class Passport implements Serializable {
    private Integer id;
    private String nationality;
    private Date expire;
    private Passport passport;

    public Passport() {
    }

    public Passport(Integer id, String nationality, Date expire) {
        this.id = id;
        this.nationality = nationality;
        this.expire = expire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", nationality='" + nationality + '\'' +
                ", expire=" + expire +
                '}';
    }
}
