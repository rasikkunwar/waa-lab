package Assignment.aspect;

import Assignment.domain.ExceptionHandler;
import Assignment.repo.ExceptionHandlerRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExceptionAspect {

    public final ExceptionHandlerRepo exceptionHandlerRepo;
    @Pointcut("execution(* Assignment.controller.UserController.checkException(..))")
    public void catchException() {

    }

    @AfterThrowing(value="catchException()",throwing="exception")
    public void doSomethingWithException(JoinPoint joinPoint, Throwable exception){
        ExceptionHandler exceptionObj = new ExceptionHandler();
        exceptionObj.setDate(LocalDate.now());
        exceptionObj.setTime(LocalTime.now());
        exceptionObj.setPrinciple("Rasik Kunwar");
        exceptionObj.setOperation(String.valueOf(joinPoint.getSignature()));
        exceptionObj.setException_type(String.valueOf(exception));
        exceptionHandlerRepo.save(exceptionObj);
    }
}
