package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//read hibernate-config file. If the name is default, it isn't wanted a way in scopes
                .addAnnotatedClass(Employee.class)//pointed the entity-class to link it with MySQL
                .buildSessionFactory();//build Session Factory:)

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Sazonov"
                    , "IT", 600);
            session.beginTransaction();//in Java I must open each transaction
            session.save(employee);
            session.getTransaction().commit();//and close each transaction (use commit)
        }
        finally {
            factory.close();
        }
    }
}
