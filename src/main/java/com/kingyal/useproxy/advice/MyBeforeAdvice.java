package com.kingyal.useproxy.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

// 前置通知类
public class MyBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        // 额外功能
        System.out.println("事务控制");
        System.out.println("日志打印");
    }
}
