package ru.zulvit.space_delivery.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingAspect {
    @Before("execution(* ru.zulvit.space_delivery.service.*.*(..)) || execution(* ru.zulvit.space_delivery.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before executing method: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* ru.zulvit.space_delivery.service.*.*(..)) || execution(* ru.zulvit.space_delivery.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("After returning from method: {}", joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* ru.zulvit.space_delivery.service.*.*(..)) || execution(* ru.zulvit.space_delivery.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("Exception in method: {}", joinPoint.getSignature().toShortString(), exception);
    }
}
