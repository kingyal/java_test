package com.kingyal.useproxy.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知，在核心之后通知，如果核心有异常，则不执行
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("MyAfterReturningAdvice !");
    }
}
