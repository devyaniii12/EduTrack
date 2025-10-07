import java.util.*;
import models.*;
import utils.DataStore;

public class CollegeManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static DataStore store;

    public static void main(String[] args) {
        store = DataStore.load();
        preloadDepartments();
        int choice;

        do {
            System.out.println("\n===== COLLEGE MANAGEMENT SYSTEM =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Courses");
            System.out.println("4. Manage Departments");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> manageStudents();
                case 2 -> manageTeachers();
                case 3 -> manageCourses();
                case 4 -> manageDepartments();
                case 0 -> {
                    store.save();
                    System.out.println("Exiting System...");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void preloadDepartments() {
        if (store.departments.isEmpty()) {
            store.departments.add(new Department(1, "Computer Science"));
            store.departments.add(new Department(2, "Information Technology"));
            store.departments.add(new Department(3, "Electronics"));
        }
    }

    // ===== STUDENT MANAGEMENT =====
    private static void manageStudents() {
        int ch;
        do {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Remove Student");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewList(store.students);
                case 3 -> updateStudent();
                case 4 -> removeById(store.students);
            }
        } while (ch != 0);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Department dept = choose(store.departments, "Department");
        Course course = choose(store.courses, "Course");

        store.students.add(new Student(id, name, age, dept, course));
        System.out.println("Student Added!");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student s = findById(store.students, id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.println("Editing: " + s);
        System.out.print("Enter new name (or press Enter to skip): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) s.setName(name);

        System.out.print("Enter new age (or 0 to skip): ");
        int age = sc.nextInt();
        if (age > 0) s.setAge(age);

        System.out.println("Change Department? (1-Yes / 0-No): ");
        if (sc.nextInt() == 1) s.setDepartment(choose(store.departments, "Department"));

        System.out.println("Change Course? (1-Yes / 0-No): ");
        if (sc.nextInt() == 1) s.setCourse(choose(store.courses, "Course"));

        System.out.println("Student Updated!");
    }

    // ===== TEACHER MANAGEMENT =====
    private static void manageTeachers() {
        int ch;
        do {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Update Teacher");
            System.out.println("4. Remove Teacher");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> addTeacher();
                case 2 -> viewList(store.teachers);
                case 3 -> updateTeacher();
                case 4 -> removeById(store.teachers);
            }
        } while (ch != 0);
    }

    private static void addTeacher() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();

        Department dept = choose(store.departments, "Department");
        store.teachers.add(new Teacher(id, name, spec, dept));
        System.out.println("Teacher Added!");
    }

    private static void updateTeacher() {
        System.out.print("Enter Teacher ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Teacher t = findById(store.teachers, id);
        if (t == null) {
            System.out.println("Teacher not found!");
            return;
        }
        System.out.println("Editing: " + t);
        System.out.print("Enter new name (or press Enter to skip): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) t.setName(name);

        System.out.print("Enter new specialization (or press Enter to skip): ");
        String spec = sc.nextLine();
        if (!spec.isEmpty()) t.setSpecialization(spec);

        System.out.println("Change Department? (1-Yes / 0-No): ");
        if (sc.nextInt() == 1) t.setDepartment(choose(store.departments, "Department"));

        System.out.println("Teacher Updated!");
    }

    // ===== COURSE MANAGEMENT =====
    private static void manageCourses() {
        int ch;
        do {
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Remove Course");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> addCourse();
                case 2 -> viewList(store.courses);
                case 3 -> updateCourse();
                case 4 -> removeById(store.courses);
            }
        } while (ch != 0);
    }

    private static void addCourse() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Credits: ");
        int credits = sc.nextInt();

        Department dept = choose(store.departments, "Department");
        store.courses.add(new Course(id, name, credits, dept));
        System.out.println("Course Added!");
    }

    private static void updateCourse() {
        System.out.print("Enter Course ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Course c = findById(store.courses, id);
        if (c == null) {
            System.out.println("Course not found!");
            return;
        }
        System.out.println("Editing: " + c);
        System.out.print("Enter new name (or press Enter to skip): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) c.setName(name);

        System.out.print("Enter new credits (or 0 to skip): ");
        int credits = sc.nextInt();
        if (credits > 0) c.setCredits(credits);

        System.out.println("Change Department? (1-Yes / 0-No): ");
        if (sc.nextInt() == 1) c.setDepartment(choose(store.departments, "Department"));

        System.out.println("Course Updated!");
    }

    // ===== DEPARTMENT MANAGEMENT =====
    private static void manageDepartments() {
        int ch;
        do {
            System.out.println("\n--- Department Menu ---");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Update Department");
            System.out.println("4. Remove Department");
            System.out.println("0. Back");
            System.out.print("Enter: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> addDepartment();
                case 2 -> viewList(store.departments);
                case 3 -> updateDepartment();
                case 4 -> removeById(store.departments);
            }
        } while (ch != 0);
    }

    private static void addDepartment() {
        System.out.print("Enter Department ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();
        store.departments.add(new Department(id, name));
        System.out.println("Department Added!");
    }

    private static void updateDepartment() {
        System.out.print("Enter Department ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Department d = findById(store.departments, id);
        if (d == null) {
            System.out.println("Department not found!");
            return;
        }
        System.out.println("Editing: " + d);
        System.out.print("Enter new name (or press Enter to skip): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) d.setName(name);
        System.out.println("Department Updated!");
    }

    // ===== HELPERS =====
    private static <T> void viewList(List<T> list) {
        if (list.isEmpty()) System.out.println("No records found.");
        else list.forEach(System.out::println);
    }

    private static <T> void removeById(List<T> list) {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();
        list.removeIf(obj -> {
            try {
                var field = obj.getClass().getDeclaredField("id");
                field.setAccessible(true);
                return (int) field.get(obj) == id;
            } catch (Exception e) {
                return false;
            }
        });
        System.out.println("Record removed if existed.");
    }

    private static <T> T choose(List<T> list, String label) {
        System.out.println("Choose " + label + ":");
        for (T t : list) System.out.println(t);
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (T t : list) {
            try {
                var field = t.getClass().getDeclaredField("id");
                field.setAccessible(true);
                if ((int) field.get(t) == id) return t;
            } catch (Exception ignored) {}
        }
        System.out.println("Invalid ID, choosing first by default.");
        return list.get(0);
    }

    private static <T> T findById(List<T> list, int id) {
        for (T t : list) {
            try {
                var field = t.getClass().getDeclaredField("id");
                field.setAccessible(true);
                if ((int) field.get(t) == id) return t;
            } catch (Exception ignored) {}
        }
        return null;
    }
}
