package com.hvs.lab.aop.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * LoggingAspect
 * <p>
 * LoggingAspect class.
 * <p>
 * <p>
 * ESTE COMPONENTE FUE CONSTRUIDO SIGUIENDO LOS ESTANDARES DE DESARROLLO Y EL PROCEDIMIENTO
 * DE DESARROLLO DE APLICACIONES DE NOVOPAYMENT Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * PROPIEDAD INTELECTUAL Y DERECHOS DE AUTOR.
 *
 * @author Novopayment Inc.
 * @author hmartinez@novopayment.com
 * @since 7/10/21
 */
@Aspect
@Service
public class LoggingAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @SneakyThrows
    @Before("@annotation(com.hvs.lab.aop.aspect.Timer)")
    public void loggingBefore(JoinPoint joinPoint) {
        LOGGER.info("Executing Before on method: {}", joinPoint.getSignature().getName());
        if (1 == 1) {
            throw new RuntimeException("TEST");
        }
        long startTime = System.currentTimeMillis();
        LOGGER.info("Start time: {}", startTime);
    }

    @SneakyThrows
    @Around("execution(* com.hvs..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint){
        LOGGER.info("Executing Around method: {}", joinPoint.getSignature().getName());
        long startTime = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        LOGGER.info("Took {} seg.", (time/1000));
        return retVal;
    }

    @After("@annotation(com.hvs.lab.aop.aspect.Timer)")
    public void loggingAfter(JoinPoint joinPoint){
        LOGGER.info("Executing After on method: {}", joinPoint.getSignature().getName());
        long endTime = System.currentTimeMillis();
        LOGGER.info("End time: {}", endTime);
    }

}
