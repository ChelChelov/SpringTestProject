package BasePackage.spring_introductions;

public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.printf("Bow-Wow");
    }
}
