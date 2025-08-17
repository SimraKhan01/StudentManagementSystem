import java.util.*;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
}

public class StudentManagement {
    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        students.add(new Student(id, name, course));
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name + " Course: " + s.course);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID: " + s.id + " Name: " + s.name + " Course: " + s.course);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new Course: ");
                s.course = sc.nextLine();
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add 2. Display 3. Search 4. Update 5. Delete 6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
