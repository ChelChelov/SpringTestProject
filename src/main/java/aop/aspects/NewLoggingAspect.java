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
        Object targetMethodResult = null;
        try {
           targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e){
            System.out.println("aroundReturnBookLoggingAdvice: it was logged Exception: " + e);

//            targetMethodResult = "unknown book";

            throw e;
        }

//        targetMethodResult = "Harry Potter";

        System.out.println("aroundReturnBookLoggingAdvice: the book was successfully returned to the library");

        return targetMethodResult;
    }
}
