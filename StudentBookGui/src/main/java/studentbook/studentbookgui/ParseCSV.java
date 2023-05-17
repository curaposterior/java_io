package studentbook.studentbookgui;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static studentbook.studentbookgui.StartApplication.main_class;

public class ParseCSV {
    public static void saveClassesToCSV(List<Class> toSave) throws IOException {
        FileWriter fwriter = new FileWriter("classes.csv");
        BufferedWriter buff_write = new BufferedWriter(fwriter);
        PrintWriter pwriter = new PrintWriter(buff_write);
        String line = "";

        //create header with column names
        for (Field field: Class.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Export.class)) {
                line = line.concat(field.getName() + ",");
            }
        }

        line = line.substring(0, line.length()-1);
        pwriter.println(line);
        for (var clas: toSave) {
            pwriter.println(clas.getGroupName()+ "," + clas.getMaxNumOfStudents());
        }
        pwriter.flush();
        pwriter.close();
    }

    public static List<Class> readClassesFromCSV() {
        List<Class> classes = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("classes.csv"));
            String line = "";
            var head = br.readLine();
            while ((line = br.readLine()) != null)  {
                String[] clas = line.split(",");
                classes.add(new Class(clas[0],
                        Integer.parseInt(clas[1])));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return classes;
    }

    public static void saveStudensToCSV(List<Student> toSave) throws IOException {
        FileWriter fwriter = new FileWriter("students.csv");
        BufferedWriter buff_write = new BufferedWriter(fwriter);
        PrintWriter pwriter = new PrintWriter(buff_write);
        String line = "";

        //create header with column names
        for (Field field: Student.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Export.class)) {
                line = line.concat(field.getName() + ",");
            }
        }
        line = line.substring(0, line.length()-1);
        pwriter.println(line);
        for (var stud: toSave) {
            pwriter.println(stud.getName() + "," + stud.getSurname() + "," + stud.getYearOfBirth());
        }
        pwriter.flush();
        pwriter.close();
    }

    public static List<Student> readStudentsFromCSV() throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            String line = "";
            var head = br.readLine();
            while ((line = br.readLine()) != null)  {
                String[] student = line.split(",");
                students.add(new Student(
                        student[0],
                        student[1],
                        StudentCondition.PRESENT,
                        Integer.parseInt(student[2])));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return students;
    }

    public static void saveGradesToCSV(String groupName, String surname, List<Integer> grades) throws IOException {
        FileWriter fwriter = new FileWriter("grades.csv");
        BufferedWriter buff_write = new BufferedWriter(fwriter);
        PrintWriter pwriter = new PrintWriter(buff_write);
        String line = "";

        //create header with column names
        line = "groupName,surname,grades";
        pwriter.println(line);
        String to_write = groupName + "," + surname + ",";
        for (var grade: grades) {
            to_write = to_write.concat(grade + " ");

        }
        to_write = to_write.substring(0, to_write.length()-1);
        pwriter.println(to_write);
        pwriter.flush();
        pwriter.close();
    }
}
