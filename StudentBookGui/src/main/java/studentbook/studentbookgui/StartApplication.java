package studentbook.studentbookgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);
//            stage.getIcons().add(new Image("C:\\Users\\empo1\\Desktop\\agh\\IO\\R_2_S_4\\Programowanie aplikacji użytkowych\\java_io\\StudentBookGui\\src\\main\\resources\\studentbook\\studentbookgui\\icons8-outline-50.png"));
            stage.getIcons().add(new Image("icons8-outline-50.png"));
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