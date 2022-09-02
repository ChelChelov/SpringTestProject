package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {


    public void getBook(Book bookName){
        System.out.println("Get UniversityLibrary book: " + bookName.getName());
    }


    String returnBook() {
        return "Return UniversityLibrary book";
    }

    public void getMagazine(){
        System.out.println("Get UniversityLibrary magazine");
    }
}
