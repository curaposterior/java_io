package studentbook.studentbookgui;

import javafx.scene.control.Alert;

import java.util.*;

public class Student implements Comparable<Student> {
    private final String id;
    private final String name;
    private final String surname;
    private String email;
    private StudentCondition condition;
    private final int yearOfBirth;
    private double points;

    public Map<Class, ClassAttributes> attributes = new HashMap<Class, ClassAttributes>();

    public Student(String name, String surname, StudentCondition condition, int yearOfBirth) {
        this.id = UUID.randomUUID().toString();
        this.email = surname + "@usos.com";
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.yearOfBirth = yearOfBirth;
//        this.attributes;
//        this.points = points;
    }

    void print() {
        System.out.println("Information about the student:");
        System.out.println("Full name: " + name + " " + surname);
        System.out.println("Student condition: " + condition);
        System.out.println("Year of birth: " + yearOfBirth);
//        System.out.println("Gathered points: " + points);
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
        return yearOfBirth == student.yearOfBirth && Double.compare(student.points, points) == 0
                && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname)
                && condition == student.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, condition, yearOfBirth);
    }

//    public void setPoints(double points) {
//        this.points = points;
//    }

//    public double getPoints() {
//        return points;
//    }

    public StudentCondition getCondition() {
        return condition;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
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

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
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

//class StudentPointsComparator implements Comparator<Student> {
//    @Override
//    public int compare(Student st1, Student st2) {
//        return Double.compare(st1.getPoints(), st2.getPoints());
//    }
//}
