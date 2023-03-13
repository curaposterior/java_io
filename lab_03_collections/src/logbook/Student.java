package logbook;

import java.util.Comparator;

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
}
