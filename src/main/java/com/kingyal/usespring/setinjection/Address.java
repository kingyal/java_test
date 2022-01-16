package com.kingyal.usespring.setinjection;

public class Address {
    private Integer id;
    private String city;

    public Address() {
        System.out.println("Address 构造方法");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("set id 方法");
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        System.out.println("set city 方法");
        this.city = city;
    }

    public void init_address() {
        System.out.println("Address 初始化方法");
    }

    public void destroy_address() {
        System.out.println("Address 销毁方法");
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
