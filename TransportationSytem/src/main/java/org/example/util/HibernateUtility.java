package org.example.util;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Vehicle.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Bus.class);
        configuration.addAnnotatedClass(Bike.class);
        configuration.addAnnotatedClass(CarType.class);

        return configuration.buildSessionFactory();
    }
}
