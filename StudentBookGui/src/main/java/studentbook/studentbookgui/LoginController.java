package studentbook.studentbookgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private FXMLLoader loader;
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
        System.out.println("Attempted login!");
        radioBtnLogin = (RadioButton)tg.getSelectedToggle();
        if (radioBtnLogin != null) {
            if (radioBtnLogin.getText().equals("Student")) {
                System.out.println("Login student");
                switchToScene1(event);
            }
//            else {
//                System.out.println("Login teacher");
//                switchToScene2(event);
//            }
        }
    }

//    public void switchToScene1(ActionEvent event) throws IOException {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
//            Scene scene = new Scene(root);
//
//            StartApplication.main_stage.setScene(scene);
//
////            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
////            window.setScene(scene);
////            window.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void switchToScene1(ActionEvent event) throws IOException {
        loader = new FXMLLoader(StartApplication.class.getResource("StudentView.fxml"));
//        root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(loader.load());
        StartApplication.main_stage.setScene(scene);
//        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TeacherView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
