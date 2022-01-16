package com.kingyal.useproxy.advice;

import org.springframework.aop.ThrowsAdvice;

// 在核心中抛出异常时执行
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception e) {
        System.out.println("MyThrowsAdvice !");
    }
}
