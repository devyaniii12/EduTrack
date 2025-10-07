package models;

public class Course {
    private int id;
    private String name;
    private int credits;
    private Department department;

    public Course(int id, String name, int credits, Department department) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.department = department;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', credits=" + credits +
               ", department=" + department.getName() + "}";
    }
}
