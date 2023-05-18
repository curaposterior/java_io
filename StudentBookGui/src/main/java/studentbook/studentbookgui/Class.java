package studentbook.studentbookgui;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static studentbook.studentbookgui.StartApplication.main_class;

public class Class implements Serializable {

    @Export
    String groupName;
    ArrayList<Student> studentList = new ArrayList<Student>();
    @Export
    int maxNumOfStudents;

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    public String getGroupName() {
    	return groupName;
    }
    
    public void setMaxStudents(int newMax) {
    	this.maxNumOfStudents = newMax;
    }
    
//    public void setStudentPoints(Student student, double points) {
//    	student.setPoints(points);
//    }
    
    public Class(String groupName, int maxNumOfStudents) {
        this.maxNumOfStudents = maxNumOfStudents;
        this.groupName = groupName;
    }

    void addStudent(Student student) throws IOException {
        if (this.studentList.contains(student)) {
            System.err.println("Student already in the list");
            throw new IOException("Student in list");
        }
        else {
            if (this.studentList.size() >= maxNumOfStudents) {
                System.err.println("Group is full");
                throw new IOException("Group is full");
            }
            this.studentList.add(student);
            Class cl = main_class.get(this.groupName);
            ClassAttributes att = new ClassAttributes(new ArrayList<>());
//            ArrayList<Integer> l = new ArrayList<>(Arrays.asList(60, 70, 80, 90, 44, 65));
            att.addGrade(10);
            att.setCondition(StudentCondition.PRESENT);
            att.calculateAverage();
            student.addAtributes(cl, att);
        }
    }

    public int getMaxNumOfStudents() {
        return maxNumOfStudents;
    }
    //    void addPoints(Student student, double points) {
//        for (Student st: this.studentList) {
//            if (student.equals(st)) {
//                st.setPoints(points);
//                break;
//            }
//        }
//    }

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

    public Student searchByEmail(String mail) {
        for (Student st: this.studentList) {
            if (st.getEmail().equals(mail)) {
                return st;
            }
        }
        return null;
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

//    ArrayList<Student> sortByPoints(ArrayList<Student> studList) {
//        ArrayList<Student> arr = (ArrayList<Student>) studList.clone();
//        arr.sort(new StudentPointsComparator());
//        return arr;
//    }

//    public Student max() {
//        return Collections.max(this.studentList, new StudentPointsComparator());
//    }
    
    @Override
    public String toString() {
        return groupName;
    }

    public void removeStudent(Student s) {
        this.studentList.remove(s);

    }
}
