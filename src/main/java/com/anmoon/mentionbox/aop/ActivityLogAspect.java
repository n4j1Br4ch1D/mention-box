package com.anmoon.mentionbox.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
@Slf4j
public class ActivityLogAspect {

    @After("execution(* com.anmoon.mentionbox.service.OmdbService.getMovieDetailsgetMovieDetails(..)) && args(name,..)")
    public void logBeforeAllMethodCall(JoinPoint joinPoint, String name) throws Throwable {
        Object[] methodArgs = joinPoint.getArgs();
        log.info("*** Just Joined In " + joinPoint.getSignature().getName()+ " ***");
        log.info("arg isssss: {}",methodArgs[0]);
        log.info("name isssss: {}", name);

    }

}
