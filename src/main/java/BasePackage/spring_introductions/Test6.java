package BasePackage.spring_introductions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Person person = context.getBean("personBean", Person.class);

        System.out.println(person.getAge());
        System.out.println(person.getSurname());
//        person.callYourPet();

//        Pet cat1 = context.getBean("catBean", Cat.class);
//        Pet cat2 = context.getBean("catBean", Cat.class);

        context.close();
    }
}
