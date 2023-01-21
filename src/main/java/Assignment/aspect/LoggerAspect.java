package Assignment.aspect;

import Assignment.domain.Logger;
import Assignment.repo.LoggerRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {
    public final LoggerRepo loggerRepo;
    @Pointcut("execution( * Assignment.controller.*.*(..))")
    public void logMe(){

    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint){
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple("Rasik Kunwar");
        logger.setOperation(String.valueOf(joinPoint.getSignature()));
        loggerRepo.save(logger);
    }
}
