package com.springboot.app.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(String com.springboot.app.springboot_aop.services.*.*(..))")
    protected void greetingLoggerPointCut() {
    }

    @Pointcut("execution(String com.springboot.app.springboot_aop.services.*.*(..))")
    protected void greetingFooLoggerPointCut() {
    }
}
