package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* getBook(aop.Book))")
    //перед ("выполнением метода(public void getBook())") нужно выполнить метод снизу (public void beforeGetBookAdvice())
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: try to get a book or magazine");
    }

    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: try to return a book or magazine");
    }
}

//@Before("execution(public void aop.UniversityLibrary.getBook(String))")
//@Before("execution(public void getBook(String))")
//@Before("execution(void getBook(String))")
//@Before("execution(* getBook(String))")
//@Before("execution(* get*(String))")
//@Before("execution(* *(String))")
//@Before("execution(* *(*))")
//@Before("execution(* *(..))")