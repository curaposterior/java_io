package studentbook.studentbookgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StartApplication extends Application {
    public static ClassContainer main_class;

    public static Stage main_stage;
    @Override
    public void start(Stage stage) throws IOException {
        try {
            //example data
            ArrayList<Student> studentListAddToClassContainer = new ArrayList<Student>();
            studentListAddToClassContainer.add(new Student("Test1", "Test1", StudentCondition.ABSENT,
                    1997));
            studentListAddToClassContainer.add(new Student("Test3", "Test3", StudentCondition.SICK,
                    2001));
            studentListAddToClassContainer.add(new Student("Test4", "Test4", StudentCondition.ABSENT,
                    1998));
            studentListAddToClassContainer.add(new Student("Test2", "Test2", StudentCondition.MAKINGUP,
                    2002));
            main_class = new ClassContainer();
            main_class.addClass("PRZYRODA", 5);
            main_class.addClass("Programowanie Równoległe", 5);
            main_class.addClass("Twoja stara", 5);

            for (Student st: studentListAddToClassContainer) {
                main_class.get("PRZYRODA").addStudent(st);
                main_class.get("Programowanie Równoległe").addStudent(st);
            }

            stage.setTitle("Main Page");
            main_stage = stage;
            FXMLLoader root = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));
            Scene scene = new Scene(root.load());

            // Add icon to the stage
            InputStream iconStream = getClass().getResourceAsStream("icons8-outline-50.png");
            Image img = new Image(iconStream);
            stage.getIcons().add(img);

            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}