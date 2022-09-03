package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution(* aop.UniversityLibrary.*(..))")
//    private void allMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("execution(* aop.UniversityLibrary.returnMagazine())")
//    private void returnMagazineMethodFromUniversityLibrary() {
//    }
//
//    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineMethodFromUniversityLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniversityLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUniversityLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #4");
//    }


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


    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();

            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book book = (Book) obj;
                    System.out.println("Information about the book. Name of the book is: " + book.getName() + " Author: " +
                            book.getAuthor() + " Date of publication: " + book.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Book add: " + obj);
                }
            }
        }
        
        System.out.println("beforeAddLoggingAdvice: log to try to get a book or magazine");
        System.out.println("-----------------------------------------");
    }


}

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