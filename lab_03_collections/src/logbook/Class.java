package logbook;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Class {
    String groupName;
    ArrayList<Student> studentList = new ArrayList<Student>();
    int maxNumOfStudents;

    void addStudent(Student student) {
        if (this.studentList.contains(student)) {
            System.out.println("Student is already in the group.");
        }
        else {
            if (this.studentList.size() >= maxNumOfStudents) {
                System.err.println("Group is full");
                return;
            }
            this.studentList.add(student);
        }
    }

    void addPoints(Student student, double points) {
        for (Student st: this.studentList) {
            if (student.equals(st)) {
                st.setPoints(points);
                break;
            }
        }
    }

    Student getStudent(Student student) { //TODO: dowiedziec sie ocb z ta metoda
        return this.studentList.get(0);
    }

    void changeCondition(Student student, StudentCondition condition) {
        for (Student st: this.studentList) {
            if (student.equals(st)) {
                st.setCondition(condition);
                break;
            }
        }
    }

    void removePoints(Student student, double points) {
        for (Student st: this.studentList) {
            if (student.equals(st)) {
                st.setPoints(points);
                break;
            }
        }
    }

    Student search(Student stud) {
        for (Student st: this.studentList) {
            if (st.compareTo(stud) == 0) {
                return st;
            }
        }
        System.err.println("Student not found. Returning null.");
        return null;
    }

    ArrayList<Student> searchPartial(String partSurname) {
        ArrayList<Student> list = new ArrayList<Student>();
        for (Student st: this.studentList) {
            if (st.getSurname().contains(partSurname)) {
                list.add(st);
            }
        }
        return list;
    }

    int countByCondition(StudentCondition condition) {
        return 0;
    }

    void summary() {
        System.out.println("Information about class:\n");
        for (Student st: this.studentList) {
            st.print();
            System.out.println();
        }
    }
//
    ArrayList<Student> sortByName() {
        ArrayList<Student> list = new ArrayList<Student>();

        return list;
    }

    ArrayList<Student> sortByPoints() {
        ArrayList<Student> list = new ArrayList<Student>();

        return list;
    }

    //max
}
