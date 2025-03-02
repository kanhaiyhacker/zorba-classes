package collection_example;

import java.util.*;

class Student {
    String name;
    String email;
    int rollNo;

    public Student(String name, String email, int rollNo) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}

public class vectorInJava {
    public static void main(String[] args) {
        Vector<Number> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(15.0);
        System.out.println(v.contains(15.0));
        System.out.println(v.isEmpty());

        LinkedList<String> names = new LinkedList<>();
        System.out.println(names.peek());

        System.out.println(names.poll());
        System.out.println("************************************");
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        System.out.println(names);
        System.out.println(names.remove("John"));
        System.out.println(names);
        for (String name : names) {
            System.out.println(name);
        }

        names.addFirst("Apple");
        names.addLast("Zebra");
        System.out.println(names);

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        ArrayList<Student> students = new ArrayList();
        students.add(new Student("Joe", "jo@gmail.com", 6));
        students.add(new Student("Kim", "jo@gmail.com", 3));
        students.add(new Student("Tom", "jo@gmail.com", 4));
        students.add(new Student("Joly", "jo@gmail.com", 2));
        System.out.println(students);

        Comparator<Student> comparator = (s1, s2) -> s1.rollNo - s2.rollNo;
        students.sort(comparator);
        System.out.println(students);

    }
    StudentInterface<String> student = new StudentInterface<String>() {

        @Override
        public String getName() {
            return "";
        }
    };
}

interface StudentInterface<T>{
    T getName();
}