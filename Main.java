import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for student data
            while (true) {
                System.out.println("Enter student name (type 'exit' to finish):");
                String name = scanner.nextLine();
                if (name.equals("exit")) {
                    break;
                }
                System.out.println("Enter student address:");
                String address = scanner.nextLine();
                double GPA;
                while (true) {
                    System.out.println("Enter student GPA:");
                    String input = scanner.nextLine();
                    try {
                        GPA = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA. Please enter a valid numeric value.");
                    }
                }
                students.add(new Student(name, address, GPA));
            }
        }

        // Sort students by GPA in descending order
        Collections.sort(students, Student.GPAComparator);

        // Write sorted student data to a text file
        try (FileWriter writer = new FileWriter("student_data.txt")) {
            for (Student student : students) {
                writer.write("Name: " + student.getName() + ", Address: " + student.getAddress() + ", GPA: " + student.getGPA() + "\n");
            }
            System.out.println("Student data has been written to student_data.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}