package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* aop.UniversityLibrary.*(..))")
    private void allMethodsFromUniversityLibrary() {
    }

    @Pointcut("execution(* aop.UniversityLibrary.returnMagazine())")
    private void returnMagazineMethodFromUniversityLibrary() {
    }

    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineMethodFromUniversityLibrary()")
    private void allMethodsExceptReturnMagazineFromUniversityLibrary(){}

    @Before("allMethodsExceptReturnMagazineFromUniversityLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice() {
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #4");
    }
}

//    @Pointcut("execution(* aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("execution(* aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("allGetMethodsFromUniversityLibrary() || allReturnMethodsFromUniversityLibrary()")
//    private void allGetAndReturnMethodsFromUniversityLibrary() {
//    }
//
//    @Before("allGetMethodsFromUniversityLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniversityLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniversityLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

//    @Pointcut("execution(* get*())")
//            private void allGetMethods(){}
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetBookAdvice: try to get a book or magazine");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: check the right to access to get book or magazine");
//    }


//@Before("execution(public void aop.UniversityLibrary.getBook(String))")
//@Before("execution(public void getBook(String))")
//@Before("execution(void getBook(String))")
//@Before("execution(* getBook(String))")
//@Before("execution(* get*(String))")
//@Before("execution(* *(String))")
//@Before("execution(* *(aop.Book))")
//@Before("execution(* *(aop.Book..))")
//@Before("execution(* *(*))")
//@Before("execution(* *(..))")