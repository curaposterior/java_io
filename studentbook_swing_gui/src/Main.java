
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /* Prezentacja funkcjonalnosci klasy Class oraz Student */
        Class klasa = new Class("GC13", 20);
        klasa.maxNumOfStudents = 10;
        Student stud = new Student("John", "Elton", StudentCondition.SICK,
                1200, 234);
        klasa.addStudent(new Student("Pablo", "Essc", StudentCondition.ABSENT,
                1000, 10));
        klasa.addStudent(new Student("John", "Krasinksi", StudentCondition.SICK,
                1200, 23));
        klasa.addStudent(new Student("Tommy", "Fury", StudentCondition.SICK,
                2314, 2323));
        klasa.summary();

        System.out.println("Sick students: " + klasa.countByCondition(StudentCondition.SICK));

        System.out.println("First sorting, by surname:\n");
        ArrayList<Student> sortedClass = klasa.sortByName(); //arraylist
        for (Student st: sortedClass) {
            st.print();
            System.out.println();
        }

        System.out.println("Second sorting, by points:\n");
        ArrayList<Student> sortedClassPoints = klasa.sortByPoints(klasa.studentList); //arraylist
        for (Student st: sortedClassPoints) {
            st.print();
            System.out.println();
        }

        System.out.println("\nMax points:");
        Student maks = klasa.max();
        maks.print();

        /* Prezentacja funkcjonalnosci klasy ClassContainer */
        ClassContainer groups = new ClassContainer();
        groups.addClass("GR01", 30);
        groups.addClass("GR02", 25);
        groups.addClass("CWL03", 10);
        ArrayList<Class> emptyGroups = groups.findEmpty();
        System.out.println("Empty groups: " + emptyGroups.size());

        groups.summary();

        ArrayList<Student> studentListAddToClassContainer = new ArrayList<Student>();
        studentListAddToClassContainer.add(new Student("Test1", "Test1", StudentCondition.ABSENT,
                1997, 231));
        studentListAddToClassContainer.add(new Student("Test3", "Test3", StudentCondition.SICK,
                2001, 2342));
        studentListAddToClassContainer.add(new Student("Test4", "Test4", StudentCondition.ABSENT,
                1998, 2135));
        studentListAddToClassContainer.add(new Student("Test2", "Test2", StudentCondition.MAKINGUP,
                2002, 545));

        Class gr01 = groups.get("GR01");
        for (Student st: studentListAddToClassContainer) {
            groups.addStudent("GR01", st);
        }

        groups.summary();

    }
}