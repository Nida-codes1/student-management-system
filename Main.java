import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add student
    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search student
    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {
                System.out.println("Student found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update student
    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();

                System.out.print("Enter new age: ");
                int age = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Enter new course: ");
                String course = scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setCourse(course);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}