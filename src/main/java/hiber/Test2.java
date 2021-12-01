package hiber;

import hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            Employee emp1 = new Employee("Kka", "fghd", "ART", 635);
            session.beginTransaction();
            session.save(emp1);
            session.getTransaction().commit();

            int myId = emp1.getId();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

        } finally {
            factory.close();
        }
    }
}
