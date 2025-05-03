package org.example;

import org.example.entity.Car;
import org.example.entity.CarType;
import org.example.util.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
Using Inheritance any strategies can be applied:
------------------------------------------------
We are trying implement Transportation Systems.
Whe
re we will be giving rent of different vehicle like bus, truck, car, scooty, bicycle
We have to design the tables accordingly so that all the data oriented properly
Make sure we have different types of
        cars available like sedan, hatback, suv.
        bus available like ac and non ac bus
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Car car1 = new Car();
            car1.setRenterName("Kanhaiya Adhikari");
            car1.setColor("Grey");
            car1.setCapacity(7);
            car1.setIsRented(true);
            car1.setRentWithDriver(false);
            car1.setManual(false);
            car1.setManufactureYear(2016);
            car1.setModel("Ford");
            car1.setMake("Li");
            CarType carType1 = new CarType();
            carType1.setType("SUV");
            car1.setCarType(carType1);

            Car car2 = new Car();
            car2.setRenterName(null);
            car2.setColor("black");
            car2.setCapacity(7);
            car2.setIsRented(false);
            car2.setRentWithDriver(false);
            car2.setManual(false);
            car2.setManufactureYear(2024);
            car2.setModel("Ford");
            car2.setMake("Li");
            car2.setCarType(carType1);


            session.persist(car1);
            session.persist(car2);


            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }

    }
}