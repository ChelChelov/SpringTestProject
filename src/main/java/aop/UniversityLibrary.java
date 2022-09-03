package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {


    public void getBook(){
        System.out.println("Get book from UniversityLibrary");
    }

    public void getMagazine(){
        System.out.println("Get magazine from UniversityLibrary");
    }

    public void returnBook() {
        System.out.println("Return book to UniversityLibrary");
    }

    public void returnMagazine(){
        System.out.println("Return magazine to UniversityLibrary");
    }

    public void addBook(){
        System.out.println("Add book to UniversityLibrary");
    }

    public void addMagazine(){
        System.out.println("Add magazine to UniversityLibrary");
    }
}
