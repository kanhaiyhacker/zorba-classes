package org.example.xml_hibernate.execute;


import org.example.xml_hibernate.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Session session = null;

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        try {
//            Transaction transaction = null;
//            Employee employee1 = new Employee();
//            employee1.setDepartment("Finance");
//            employee1.setSalary(55000);
//            employee1.setName("Himashu Dev");
//            transaction = session.beginTransaction();
//            session.persist(employee1);
//            transaction.commit();
//
        } catch (HibernateException e) {
            System.out.println("Hibernate Exception" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        Session session1 = sessionFactory.openSession();
        Employee employee = session1.get(Employee.class, 1);
        System.out.println("Fetched employee: " + employee);

       Transaction tx =  session1.beginTransaction();
        session1.remove(employee);
        tx.commit();
        System.out.println("Removed employee: " + employee);
        session1.close();

    }
}