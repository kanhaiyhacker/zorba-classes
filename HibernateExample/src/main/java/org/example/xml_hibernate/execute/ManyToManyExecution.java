package org.example.xml_hibernate.execute;

import org.example.xml_hibernate.model.Book;
import org.example.xml_hibernate.model.Student;
import org.example.xml_hibernate.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManyToManyExecution {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtility.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        List<Student> students = getStudents();
        for (Student student : students) {
            session.persist(student);
        }
        tx.commit();
    }


    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("Kanhaiya Adhikari");
        student1.setGender("Male");

        Student student2 = new Student();
        student2.setName("Gaurav");
        student2.setGender("Male");

        Student student3 = new Student();
        student3.setName("Anuj ");
        student3.setGender("Male");

        Student student4 = new Student();
        student4.setName("Yasodha");
        student4.setGender("Female");

        Student student5 = new Student();
        student5.setName("Amit");
        student5.setGender("Male");

        Book book1 = new Book();
        book1.setBookTitle("Java Hibernate");
        book1.setBookAuthor("Abhishek");

        Book book2 = new Book();
        book2.setBookTitle("Java SQL");
        book2.setBookAuthor("Abhishek");


        Set<Book> bookSet1 = new HashSet<>();
        bookSet1.add(book1);
        bookSet1.add(book2);

        student1.setBooks(bookSet1);
        student2.setBooks(bookSet1);
        student3.setBooks(bookSet1);
        student4.setBooks(bookSet1);
        student5.setBooks(bookSet1);


        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        return students;
    }
}
