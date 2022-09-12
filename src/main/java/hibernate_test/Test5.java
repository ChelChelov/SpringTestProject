package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//read hibernate-config file. If the name is default, it isn't wanted a way in scopes
                .addAnnotatedClass(Employee.class)//pointed the entity-class to link it with MySQL
                .buildSessionFactory();//build Session Factory:)

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);

            session.createQuery("delete Employee where name = 'Aleksandra'")
                            .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}