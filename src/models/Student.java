package models;

public class Student {
    private int id;
    private String name;
    private int age;
    private Department department;
    private Course course;

    public Student(int id, String name, int age, Department department, Course course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.course = course;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age +
               ", department='" + department.getName() + "', course='" + course.getName() + "'}";
    }
}
