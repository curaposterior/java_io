package logbook;

import java.lang.reflect.Array;
import java.util.*;

public class Class {
    String groupName;
    ArrayList<Student> studentList = new ArrayList<Student>();
    int maxNumOfStudents;

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public Class(String groupName, int maxNumOfStudents) {
        this.maxNumOfStudents = maxNumOfStudents;
        this.groupName = groupName;
    }

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

    Student getStudent(Student student) {
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
        int counter = 0;
        for (Student st: this.studentList) {
            if (st.getCondition().equals(condition)) {
                counter = counter + 1;
            }
        }
        return counter;
    }

    void summary() {
        if (this.studentList.size() == 0) {
            System.out.println("Class is empty.");
        }
        else {
            System.out.println("Information about class:\n");
            for (Student st : this.studentList) {
                st.print();
                System.out.println();
            }
        }
    }

    ArrayList<Student> sortByName() {
        ArrayList<Student> list = (ArrayList<Student>) this.studentList.clone();
        Collections.sort(list);
        return list;
    }

    ArrayList<Student> sortByPoints(ArrayList<Student> studList) {
        ArrayList<Student> arr = (ArrayList<Student>) studList.clone();
        arr.sort(new StudentPointsComparator());
        return arr;
    }

    public Student max() {
        return Collections.max(this.studentList, new StudentPointsComparator());
    }
}
