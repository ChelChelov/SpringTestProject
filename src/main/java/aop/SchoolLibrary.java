package aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

    public void getBook() {
        System.out.println("Get SchoolLibrary book");
    }

    public void returnBook() {
        System.out.println("Return SchoolLibrary book");
    }
}
