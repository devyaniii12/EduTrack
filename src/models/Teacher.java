package models;

public class Teacher {
    private int id;
    private String name;
    private String specialization;
    private Department department;

    public Teacher(int id, String name, String specialization, Department department) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.department = department;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Teacher{id=" + id + ", name='" + name + "', specialization='" + specialization +
               "', department='" + department.getName() + "'}";
    }
}
