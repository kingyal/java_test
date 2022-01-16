package com.kingyal.useproxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    /**
     * jdk动态代理
     */
    @Test
    public void test1() {
        final FangDongService fangDongService = new FangDongServiceImpl();

        InvocationHandler ih = new InvocationHandler(){
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 辅助功能，额外功能
                System.out.println("发布租房信息");
                System.out.println("带租客看房");
                // 核心业务
                fangDongService.zufang();
                return null;
            }
        };

        // 动态生成代理类
        FangDongService proxy = (FangDongService)Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                fangDongService.getClass().getInterfaces(),
                ih);

        proxy.zufang();
    }

    /**
     * CGlib动态代理
     */
    @Test
    public void test2() {
        final FangDongService fangDongService = new FangDongServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FangDongServiceImpl.class);
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                // 辅助功能，额外功能
                System.out.println("发布租房信息");
                System.out.println("带租客看房");
                // 核心业务
                fangDongService.zufang();
                return null;
            }
        });

        FangDongServiceImpl proxy = (FangDongServiceImpl)enhancer.create();
        proxy.zufang();
    }
}
