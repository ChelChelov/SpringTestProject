package BasePackage.spring_introductions;

public class Person {
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
        System.out.println("Person bean is created");
    }

    public void callYourPet(){
        System.out.println("Hi my lovely sausage");
        pet.say();
    }
}
