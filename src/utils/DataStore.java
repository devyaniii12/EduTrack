package utils;

import java.util.*;
import java.io.*;
import models.*;

public class DataStore implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Student> students = new ArrayList<>();
    public List<Teacher> teachers = new ArrayList<>();
    public List<Course> courses = new ArrayList<>();
    public List<Department> departments = new ArrayList<>();

    public static DataStore load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            return (DataStore) ois.readObject();
        } catch (Exception e) {
            return new DataStore(); // new empty datastore
        }
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            oos.writeObject(this);
        } catch (Exception ignored) {}
    }
}
