package com.example.config;

import com.example.controller.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Component
@Aspect
public class DemoAspect {
    @Pointcut("execution(* com.example.controller.BookController.*delete(..))")
    public void bookControllerDeleteMethod(){}
//
//    @Before("bookControllerMethod()")
//    public void beforeCallMethod(JoinPoint joinPoint){
//        System.err.println("Start method name: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
//    }
//
    @After("bookControllerDeleteMethod()")
    public void afterCallMethodDelete(JoinPoint joinPoint){
//        System.err.println("End method name delete: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
        System.err.println("1 cuốn sách đã dc trả lúc: " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.example.controller.BookController.*save(..))")
    public void bookControllerSaveMethod(){}

    @After("bookControllerSaveMethod()")
    public void afterCallMethodSave(JoinPoint joinPoint){
//        System.err.println("End method name save: " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
        System.err.println("1 cuốn sách đã dc mượn lúc: " + LocalDateTime.now());
    }

}
