package com.example.ss8_ung_dung_muon_sach.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    @After("execution(* com.example.ss8_ung_dung_muon_sach.controller..*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println(" Hành vi người dùng: " + joinPoint.getSignature().getName());
    }

}
