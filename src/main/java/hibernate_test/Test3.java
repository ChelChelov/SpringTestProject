package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//read hibernate-config file. If the name is default, it isn't wanted a way in scopes
                .addAnnotatedClass(Employee.class)//pointed the entity-class to link it with MySQL
                .buildSessionFactory();//build Session Factory:)

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee")
//                            .getResultList();

            List<Employee> employees = session.createQuery("from Employee " +
                            "where salary > 800")
                    .getResultList();

            for (Employee e:
                 employees) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}