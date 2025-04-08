package com.example.faceappdetector.aspect;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class SaveDataToDbClass {

    @SneakyThrows
    @Around("@annotation(com.example.faceappdetector.aspect.SaveDataToDb)")
    public Object saveDataToDb(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Method execution time: " + joinPoint.getSignature().getName() + " " + (end - start) + "ms");
        return result;
    }
}
