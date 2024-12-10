package com.relatenest.utilities;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LogMethodParamAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogMethodParamAspect.class);

    @Before("@annotation(LogMethodParam)")
    public void logParameters(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method {} called with parameters: {}", methodName, Arrays.toString(args));
    }
}