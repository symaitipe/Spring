package com.sahan.springAOP.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    //---------------------------------------------- Execution() ------------------------------------------------------------
    /*
        advice - Before
        pointcut - execution
        join point - execution of getAllProduct()
    */
    @Before("execution(* com.sahan.springAOP.controller.ProductController.getAllProducts(..))")
    public void logBeforeExecution(JoinPoint joinPoint){

        // Method name
        String methodName = joinPoint.getSignature().getName();

        // Class name
        String className = joinPoint.getTarget().getClass().getSimpleName();

        // Method arguments
        Object[] args = joinPoint.getArgs();

        System.out.println("Executing method: " + className + "." + methodName);

        if (args.length > 0) {
            System.out.println("Arguments passed:");
            for (Object arg : args) {
                System.out.println(" - " + arg);
            }
        } else {
            System.out.println("No arguments passed.");
        }
        System.out.println(" Methods executed ");
    }


       /*
        advice - After
        pointcut - execution
        join point - execution of getAllProductById()
    */

    @After("execution(* com.sahan.springAOP.controller.ProductController.getProductById(int))")
    public void logAfterExecution(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        System.out.println("Executing method: " + className + "." + methodName);

        if (args.length > 0) {
            System.out.println("Arguments passed:");
            for (Object arg : args) {
                System.out.println(" - " + arg);
            }
        } else {
            System.out.println("No arguments passed.");
        }
        System.out.println(" Methods executed ");
    }





}
