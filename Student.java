import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    public static Comparator<Student> GPAComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getGPA(), s1.getGPA()); // Descending order by GPA
        }
    };
}