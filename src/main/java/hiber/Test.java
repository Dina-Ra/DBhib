package hiber;

import hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            Employee emp1 = new Employee("Loo", "ERSA", "ART", 423);
            session.beginTransaction();

            session.save(emp1);
            session.getTransaction().commit();
            System.out.println(emp1);
        } finally {
            factory.close();
        }
    }
}


