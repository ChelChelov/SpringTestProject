package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: logging the getting the list of students " +
                "before getStudents() method");
    }

    @AfterReturning(pointcut = "execution(* getStudents())"
            , returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        Student first = students.get(0);

        String nameSurname = first.getNameSurname();
        nameSurname = "Mr: " + nameSurname;
        first.setNameSurname(nameSurname);

        double avgGrade = first.getAvgGrade();
        avgGrade = avgGrade + 1;
        first.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAdvice: logging the getting the list of students" +
                "after getStudents() method have been worked");
    }
}
