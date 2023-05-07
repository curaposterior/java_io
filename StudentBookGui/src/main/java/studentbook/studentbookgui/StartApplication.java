package studentbook.studentbookgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class StartApplication extends Application {

    public static Stage main_stage;
    @Override
    public void start(Stage stage) throws IOException {
        try {
            stage.setTitle("Main Page");
            main_stage = stage;
//            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            FXMLLoader fxmllllloader = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));

            Scene scene = new Scene(fxmllllloader.load());

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