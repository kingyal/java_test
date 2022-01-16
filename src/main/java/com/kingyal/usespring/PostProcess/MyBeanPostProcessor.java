package com.kingyal.usespring.PostProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * 后处理发生在bean的生命周期的init阶段，即构造，set,前置后处理，init，后置后处理，销毁
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("***** 前置后处理 *****");
        System.out.println("前置处理：" + bean + " : " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("***** 前置后处理 *****");
        System.out.println("后置处理：" + bean + " : " + beanName);
        return bean;
    }
}
