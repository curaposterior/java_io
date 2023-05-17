package studentbook.studentbookgui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import studentbook.studentbookgui.StartApplication;
import studentbook.studentbookgui.Student;
import studentbook.studentbookgui.StudentCondition;

import static studentbook.studentbookgui.StartApplication.main_class;

public class ChangeStudentInfoController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;
    private StudentController studentController;
    private Student stud;
    @FXML
    private TextField changeEmailField;

    @FXML
    private ComboBox<StudentCondition> conditonComboBox;

    @FXML
    private Button cancelInformation;

    @FXML
    private Button acceptInformation;

    public void setStudentController(StudentController controller) {
        this.studentController = controller;
    }

    public void setStudent(Student student) {
        this.stud = student;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void cancel(ActionEvent event) {
        stage.close();
    }

    @FXML
    public void populate(Student student) {
        ObservableList<StudentCondition> conditions = FXCollections.observableArrayList();

        // Add the items from the StudentCondition enum
        conditions.addAll(StudentCondition.SICK, StudentCondition.PRESENT);
        conditonComboBox.setItems(conditions);
        changeEmailField.setText(student.getEmail());
    }

    @FXML
    public void accept(ActionEvent event) {
        String mail = changeEmailField.getText();
        StudentCondition cond = conditonComboBox.getValue();
        if (mail != null && !mail.equals("") &&
            cond != null) {
            if (!main_class.checkEmail(mail)) {
                stud.setEmail(mail);
                stud.setCondition(cond);

//                loader = new FXMLLoader(StartApplication.class.getResource("StudentView.fxml"));
//                StudentController contr = loader.getController();
//                contr.displayEmail(mail);
                studentController.updateCurrentStudent(stud);
                stage.close();
            }
            else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Błąd");
                al.setContentText("Zły mail");
                al.show();
            }
        }
        else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Błąd");
            al.setContentText("Niepoprawne dane");
            al.show();
        }
    }
}
