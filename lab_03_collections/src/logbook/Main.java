package logbook;

public class Main {
    public static void main(String[] args) {
        Class klasa = new Class("GC13", 20);
        klasa.maxNumOfStudents = 10;
        var stud = new Student("John", "Krasinksi", StudentCondition.SICK,
                1200, 23);
        klasa.addStudent(new Student("John", "Krasinksi", StudentCondition.SICK,
                1200, 23));
        klasa.addStudent(new Student("John", "Krasinksi", StudentCondition.SICK,
                1200, 23));


        klasa.summary();
        klasa.changeCondition(stud, StudentCondition.MAKINGUP);
        klasa.summary();
    }
}