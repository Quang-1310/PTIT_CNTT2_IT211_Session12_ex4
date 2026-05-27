package ra.edu.ptit_cntt2_it211_session12_ex4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* ra.edu.ptit_cntt2_it211_session12_ex4.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("AOP BEFORE - Method: {} - Args: {}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(
            pointcut = "execution(* ra.edu.ptit_cntt2_it211_session12_ex4.service.*.*(..))",
            throwing = "exception"
    )
    public void logAfterThrowingService(JoinPoint joinPoint, Throwable exception) {
        log.warn("AOP AFTER THROWING - Method: {} - Exception: {}",
                joinPoint.getSignature().getName(),
                exception.getMessage());
    }

    @Around("execution(* ra.edu.ptit_cntt2_it211_session12_ex4.controller.*.*(..))")
    public Object logAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("AOP AROUND - Method: {} - Time: {} ms",
                joinPoint.getSignature().getName(),
                end - start);

        return result;
    }
}
