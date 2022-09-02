package BasePackage.spring_introductions;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")
public class Person {
//    @Autowired
//    @Qualifier("dog")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    //    @Autowired
//    public Person(@Qualifier("cat") Pet pet) {
//        this.pet = pet;
//        System.out.println("Person bean is created");
//    }

    public Person() {
        System.out.println("Person bean is created");
    }

//    @Autowired
//    @Qualifier("dog")
//    public void setPet(Pet pet) {
//        System.out.println("Class Person set Pet");
//        this.pet = pet;
//    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person set age");
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hi my lovely sausage");
        pet.say();
    }
}
