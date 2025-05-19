package org.kanhaiya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExecuteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApplicationConfig.class);
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
