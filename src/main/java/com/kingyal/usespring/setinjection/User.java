package com.kingyal.usespring.setinjection;

import java.util.*;

public class User {
    private Integer id;
    private String passwd;
    private String sex;
    private Integer age;
    private Date bornDate;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> names;
    private Map<String ,String> countries;
    private Properties properties;
    private Address address;

    public User() {
        System.out.println("构造User用户对象");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + "\n "+
                ", passwd='" + passwd + '\'' + "\n "+
                ", sex='" + sex + '\'' + "\n "+
                ", age=" + age + "\n "+
                ", bornDate=" + bornDate + "\n "+
                ", hobbys=" + Arrays.toString(hobbys) + "\n "+
                ", phones=" + phones + "\n "+
                ", names=" + names + "\n "+
                ", countries=" + countries + "\n "+
                ", properties=" + properties + "\n "+
                ", address.city=" + address.getCity() + "\n "+
                ", address.id=" + address.getId() + "\n "+
                '}';
    }
}
