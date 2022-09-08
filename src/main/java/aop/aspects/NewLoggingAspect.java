package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: it was tried to return a book to the library");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
        targetMethodResult = "Harry Potter";
        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: it was successfully returned a book to the library");
        System.out.println("aroundReturnBookLoggingAdvice: method returnBook() have done its work for " +
                (end - begin) + " millis");
        return targetMethodResult;
    }
}
