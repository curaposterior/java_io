package studentbook.studentbookgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import studentbook.studentbookgui.controller.ConfirmController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class StartApplication extends Application {
    public static ClassContainer main_class;

    public static Stage main_stage;
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, FileNotFoundException {
//        try {
//            //example data
//            ArrayList<Student> studentListAddToClassContainer = new ArrayList<Student>();
//            studentListAddToClassContainer.add(new Student("Test1", "Test1", StudentCondition.ABSENT,
//                    1997));
//            studentListAddToClassContainer.add(new Student("Test3", "Test3", StudentCondition.ABSENT,
//                    2001));
//            studentListAddToClassContainer.add(new Student("Test4", "Test4", StudentCondition.ABSENT,
//                    1998));
//            studentListAddToClassContainer.add(new Student("Test2", "Test2", StudentCondition.ABSENT,
//                    2002));
//            main_class = new ClassContainer();
//            main_class.addClass("Podstawy Programowania", 5);
//            main_class.addClass("Programowanie Równoległe", 5);
//            main_class.addClass("Modelowanie matematyczne", 5);
//            main_class.addClass("Analiza matematyczna", 1);
//            main_class.addClass("Geometria Obliczeniowa", 1);
//
//            for (Student st: studentListAddToClassContainer) {
//                main_class.get("Modelowanie matematyczne").addStudent(st);
//                main_class.get("Programowanie Równoległe").addStudent(st);
//            }
//
//
//
////            test1.addGrade("Modelowanie matematyczne", 60);
//            main_class.get("Modelowanie matematyczne").getStudentList().get(0)
//                    .addGrade("Modelowanie matematyczne", 10);
            try {
                main_class = ClassContainerSerialization.load();
            } catch (Exception e) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                System.err.println(e.getMessage());
                al.setTitle("Błąd wczytywania danych");
                al.setContentText("Wczytywanie danych zakończyło się niepowodzeniem. Plik nie został znaleziony");
                al.show();
            }
            stage.setTitle("Login");
            main_stage = stage;
            FXMLLoader root = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));
            Scene scene = new Scene(root.load());

            main_stage.setOnCloseRequest(req -> {
                try {
                    saveData();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            });

            InputStream iconStream = getClass().getResourceAsStream("icons8-outline-50.png");
            Image img = new Image(iconStream);
            stage.getIcons().add(img);

            stage.setScene(scene);
            stage.show();

//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    public void saveData() throws IOException {
        boolean choice = ConfirmController.show("Zamykanie aplikacji","Czy chcesz zapisac dane?");
        if (choice) {
            //do sth
            ClassContainerSerialization.save();
//            ParseCSV.saveStudensToCSV(main_class.getGroups().get("Modelowanie matematyczne").getStudentList());
//            ParseCSV.saveClassesToCSV(main_class.getGroupsArray());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}