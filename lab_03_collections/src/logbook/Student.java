package logbook;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private StudentCondition condition;
    private int yearOfBirth;
    private double points;
    //date of birth?


    public Student(String name, String surname, StudentCondition condition, int yearOfBirth, double points) {
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
    }

    void print() {
        System.out.println("Information about student:");
        System.out.println("Full name: " + name + " " + surname);
        System.out.println("Student condition: " + condition);
        System.out.println("Year of birth: " + yearOfBirth);
        System.out.println("Gathered points: " + points);
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
        return yearOfBirth == student.yearOfBirth && Double.compare(student.points, points) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && condition == student.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, condition, yearOfBirth, points);
    }

    public void setPoints(double points) {
        this.points += points;
    }

    public double getPoints() {
        return points;
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public String getSurname() {
        return surname;
    } 
}
