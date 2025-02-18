package com.sahan.spring_security.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class ExecutionAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExecutionAspect.class);

    @AfterReturning(pointcut = "within(com.sahan.spring_security.controller..*)")
    public void successfullyExecuted(JoinPoint jp) {
        logger.info(jp.getSignature().getName()+" is Executed Successfully....");
    }

    @AfterThrowing(pointcut = "within(com.sahan.spring_security.controller..*)", throwing = "ex")
    public void errorOccurred(JoinPoint jp, Exception ex) {
        logger.error("Exception in method: {} - Exception: {}",
                jp.getSignature().getName(),
                ex.getMessage(),
                ex);
    }

}
