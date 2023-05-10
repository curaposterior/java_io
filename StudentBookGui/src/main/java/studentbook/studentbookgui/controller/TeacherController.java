package studentbook.studentbookgui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import studentbook.studentbookgui.StartApplication;

import java.io.IOException;

public class TeacherController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    @FXML
    private Button btnLogout;

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));
        scene = new Scene(root.load());
        StartApplication.main_stage.setScene(scene);
    }
}
