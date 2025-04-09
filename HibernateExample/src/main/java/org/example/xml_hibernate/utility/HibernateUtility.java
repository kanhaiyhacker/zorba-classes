package org.example.xml_hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        return config.buildSessionFactory();
    }
}
