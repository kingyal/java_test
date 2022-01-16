package com.kingyal.useproxy.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("核心功能开始！！！");
        Object object = methodInvocation.proceed(); // 触发执行核心功能
        System.out.println("核心功能结束！！！");
        return object;
    }
}
