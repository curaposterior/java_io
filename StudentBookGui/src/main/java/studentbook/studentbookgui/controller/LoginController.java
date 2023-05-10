package studentbook.studentbookgui.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import studentbook.studentbookgui.StartApplication;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Scene scene2;
    private Parent root;

    private FXMLLoader loader;
    private FXMLLoader loader_2;
    @FXML
    private Button loginButton;

    @FXML
    private TextField user_login;

    @FXML
    private PasswordField user_password;

    @FXML
    private RadioButton radioBtnLogin;

    @FXML
    private ToggleGroup tg;

    public void login(ActionEvent event) throws IOException {
        System.out.println("Attempted login");
        radioBtnLogin = (RadioButton)tg.getSelectedToggle();
        if (radioBtnLogin != null) {
            if (radioBtnLogin.getText().equals("Student")) {
                System.out.println("Login student");
                switchToScene1(event);
            }
            else {
                System.out.println("Login teacher");
                switchToScene2(event);
            }
        }
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        loader = new FXMLLoader(StartApplication.class.getResource("StudentView.fxml"));
        root = loader.load();
        Stage newStage = new Stage();
        String mail = user_login.getText();
        if (!Objects.equals(mail, "")) {
            StudentController contr = loader.getController();
//            contr.displayEmail(mail);
            contr.displayEmail("Test1@usos.com");
            scene = new Scene(root);
//            StartApplication.main_stage.setScene(scene);
            newStage.setScene(scene);
            newStage.show();
        }
    }
    public void switchToScene2(ActionEvent event) throws IOException {
//        loader_2 = new FXMLLoader(StartApplication.class.getResource("TeacherView.fxml"));
//        scene2 = new Scene(loader_2.load());
//        StartApplication.main_stage.setScene(scene2);
        loader_2 = new FXMLLoader(StartApplication.class.getResource("TeacherView.fxml"));
        Parent root = loader_2.load();
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
    }
}
