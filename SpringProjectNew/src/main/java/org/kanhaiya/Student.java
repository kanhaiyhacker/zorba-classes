package org.kanhaiya;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name = "Kanhaiya";
    private int rollNo = 25;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}
