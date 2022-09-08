package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {


    public void getBook(){
        System.out.println("Get book from UniversityLibrary");
        System.out.println("-----------------------------------------");
    }

    public void getMagazine(){
        System.out.println("Get magazine from UniversityLibrary");
        System.out.println("-----------------------------------------");
    }

    public String returnBook() {
        System.out.println("Return book to UniversityLibrary");
        return "The Witcher";
    }

    public void returnMagazine(){
        System.out.println("Return magazine to UniversityLibrary");
        System.out.println("-----------------------------------------");
    }

    public void addBook(String personName, Book book){
        System.out.println("Add book to UniversityLibrary");
        System.out.println("-----------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Add magazine to UniversityLibrary");
        System.out.println("-----------------------------------------");
    }
}
