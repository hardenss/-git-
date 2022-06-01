package com.example.demo.Configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GouLinJunAop {
    @Pointcut("@annotation(com.example.demo.zhujie.GouLinJun)")
    public void GouLinJun(){

    }
    @Before("GouLinJun()")
    public Object doAround(JoinPoint joinPoint){
        System.out.println(joinPoint);

        for (Object arg : joinPoint.getArgs()) {
            System.out.println(arg);
        }
        return joinPoint;
    }
}
