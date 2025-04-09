package org.example.xml_hibernate.model;

import java.util.Set;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private int yearOfPublication;
    private Set<Student> assignedStudents;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Set<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(Set<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }
}
