package studentbook.studentbookgui;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.*;

public class Student implements Comparable<Student>, Serializable {
    @Export
    private final String name;
    @Export
    private final String surname;
    private String email;
    private StudentCondition condition;
    @Export
    private int yearOfBirth;

    public Map<Class, ClassAttributes> attributes = new HashMap<Class, ClassAttributes>();

    public Student(String name, String surname, StudentCondition condition, int yearOfBirth) {
        this.email = surname + "@usos.com";
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.yearOfBirth = yearOfBirth;
    }

    void print() {
        System.out.println("Information about the student:");
        System.out.println("Full name: " + name + " " + surname);
        System.out.println("Student condition: " + condition);
        System.out.println("Year of birth: " + yearOfBirth);
    }

    public void addGrade(String grName, int grade) {
        try {
            if (attributes.containsKey(grName)) {
                attributes.get(grName).addGrade(grade);
            }
            else {
                System.err.println("You are not signed up for this course");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.surname.compareTo(o.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfBirth == student.yearOfBirth
                && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname)
                && condition == student.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, condition, yearOfBirth);
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    } 
    
    @Override
    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", condition=" + condition +
//                ", yearOfBirth=" + yearOfBirth +
//                ", points=" + points +
//                '}';
    	return name + "/" + surname + "/"  + condition + "/";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void addAtributes(Class add_class, ClassAttributes add_attributes) {
        if (attributes.containsKey(add_class) && attributes != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("Class already exists");
            alert.showAndWait();
        }
        else {
            attributes.put(add_class, add_attributes);
        }
    }
}
