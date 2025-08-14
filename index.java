import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}

public class StudentGradeManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student marks: ");
        int marks = sc.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks should be between 0 and 100.");
            return;
        }

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        System.out.printf("%-20s %-10s %-10s\n", "Name", "Marks", "Grade");
        for (Student s : students) {
            System.out.printf("%-20s %-10d %-10s\n", s.name, s.marks, s.getGrade());
        }
    }
}
