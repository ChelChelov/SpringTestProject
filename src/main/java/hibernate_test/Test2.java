package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//read hibernate-config file. If the name is default, it isn't wanted a way in scopes
                .addAnnotatedClass(Employee.class)//pointed the entity-class to link it with MySQL
                .buildSessionFactory();//build Session Factory:)

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Sidorov"
                    , "IT", 1200);
            session.beginTransaction();//in Java I must open each transaction
            session.save(employee);

            int myId = employee.getId();

            Employee employee1 = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee1);

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
