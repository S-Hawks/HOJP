package com.faiaz.signup_signin.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {

    /*
    In this application context we implement ApplicationContextAware which is an interface it implements a default method and have e method that get a perimeter
    which is mainly a springBean pass to this method. further we need to annotate this class as component, or we can declare a bean(in this case we declare a bean in configuration class)
    facility of using spring bean.
        1. component mainly manage by spring automatically
        2. if we bean in configuration class we have ability to perform custom login, condition etc
    * */
    private static ApplicationContext CONTEXT;

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }
}
