package studentbook.studentbookgui.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import studentbook.studentbookgui.*;
import studentbook.studentbookgui.Class;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static studentbook.studentbookgui.StartApplication.main;
import static studentbook.studentbookgui.StartApplication.main_class;

public class StudentController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    public static Student curr_student;
    @FXML
    private Label labelDisplayMail;

    @FXML
    private TextField searchClasses;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnJoinClass;

    @FXML
    private Button btnShowStudentClass;

    @FXML
    private TableView<DisplayClassForStudent> tableVStudentClasses;

    @FXML
    private TableColumn<DisplayClassForStudent, String> groupNameColumn;

    @FXML
    private TableColumn<DisplayClassForStudent, String> gradeColumn;

    @FXML
    private TableColumn<DisplayClassForStudent, Integer> averageColumn;

    @FXML
    private TableColumn<DisplayClassForStudent, StudentCondition> conditionColumn;

    @FXML
    private ListView<String> listViewCourses;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Tooltip capacityTooltip;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void showCapacity() {
        String selectedGroup = listViewCourses.getSelectionModel().getSelectedItem();
        if (selectedGroup != null) {
            String name = listViewCourses.getSelectionModel().selectedItemProperty().getValue();
            Class c = main_class.get(name);
            double capacity = (double) c.getStudentList().size() / c.getMaxNumOfStudents();
            progressBar.setProgress(capacity);


            //System.out.println(prettySummary(test));
            capacityTooltip = new Tooltip();
            String output = "Pojemność: " + String.valueOf(main_class.get(selectedGroup).getStudentList().size() /
                    main_class.get(selectedGroup).getMaxNumOfStudents() * 100);
            capacityTooltip.setText(output);
        }
    }

    @FXML
    public void showStudentClasses(ActionEvent event) throws IOException {
        String mail = labelDisplayMail.getText();
        tableVStudentClasses.getItems().clear();
        for (Class search_class: main_class.getGroups().values()) {
            Student st = search_class.searchByEmail(mail);
            if (st != null) {
                curr_student = st;
            }
        }
        if (curr_student != null) {
            groupNameColumn.setCellValueFactory(new PropertyValueFactory<>("groupName"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grades"));
            averageColumn.setCellValueFactory(new PropertyValueFactory<>("average"));
            conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

//            DisplayClassForStudent ob = new DisplayClassForStudent(curr_student.attributes.get(),
//                                                                    )
            for (Map.Entry<Class, ClassAttributes> entry: curr_student.attributes.entrySet()) {
                Class key = entry.getKey();
                ClassAttributes val = entry.getValue();
                DisplayClassForStudent ob = new DisplayClassForStudent(
                        key.getGroupName(),
                        val.getGrades(),
                        val.getAverage(),
                        val.getCondition()
                );
                tableVStudentClasses.getItems().add(ob);
            }
        }
    }

    @FXML
    public void searchClasses(ActionEvent event) {
        if (searchClasses.getText() != null && curr_student != null) {
            String txt = searchClasses.getText();
            tableVStudentClasses.getItems().clear();
            for (Map.Entry<Class, ClassAttributes> entry: curr_student.attributes.entrySet()) {
                Class key = entry.getKey();
                ClassAttributes val = entry.getValue();
                if (key.getGroupName().contains(txt)) {
                    DisplayClassForStudent ob = new DisplayClassForStudent(
                            key.getGroupName(),
                            val.getGrades(),
                            val.getAverage(),
                            val.getCondition()
                    );
                    tableVStudentClasses.getItems().add(ob);
                }
            }
        }
    }

    @FXML
    void clickMouseShow(ActionEvent event) {
        if (!listViewCourses.getSelectionModel().selectedItemProperty().getValue().equals("")) {
            String name = listViewCourses.getSelectionModel().selectedItemProperty().getValue();
            Class c = main_class.get(name);
            double val = (double) c.getStudentList().size() / c.getMaxNumOfStudents();
            progressBar.setProgress(val);
        }
        System.out.println("Empty");
    }
    @FXML
    public void joinClass(ActionEvent event) {
        if (!listViewCourses.getSelectionModel().selectedItemProperty().getValue().equals("")) {
            String name = listViewCourses.getSelectionModel().selectedItemProperty().getValue();
            try {
                main_class.addStudent(name, this.curr_student);
                showStudentClasses(event);
            } catch (Exception e)  {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Student jest już zapisany na przedmiot");
                a.show();
            }
        }
    }

    @FXML
    public void quitClass(ActionEvent event) throws IOException {
        DisplayClassForStudent cl = tableVStudentClasses.getSelectionModel().getSelectedItem();
        if (cl != null) {
            Class c = main_class.get(cl.getGroupName());
            c.removeStudent(curr_student);
            curr_student.attributes.remove(c);
            showStudentClasses(event);
        }
    }

    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
//        root = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));
//        scene = new Scene(root.load());
//        StartApplication.main_stage.setScene(scene);
        stage.close();
    }


    @FXML
    void changeStudentInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("ChangeStudentInfo.fxml"));
        Parent root = loader.load();

        ChangeStudentInfoController changeStudentInfoController = loader.getController();
        changeStudentInfoController.setStudentController(this);
        changeStudentInfoController.setStudent(curr_student);
        changeStudentInfoController.populate(curr_student);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
//        FXMLLoader change_info_loader = new FXMLLoader(StartApplication.class.getResource("ChangeStudentInfo.fxml"));
//        Parent root = change_info_loader.load();
//        ChangeStudentInfoController contr = change_info_loader.getController();
//
//        Stage newStage = new Stage();
//        Scene newScene = new Scene(root);
//        newStage.setScene(newScene);
//        contr.setStage(newStage);
//        contr.populate(curr_student);
//        contr.setStudent(curr_student);
//        newStage.show();
    }
    @FXML
    void showCourses(ActionEvent event) {
        List<Class> ls = main_class.getGroupsArray();
        List<String> list_strings = new ArrayList<String>();
        for (Class c: ls) {
            list_strings.add(c.toString());
        }
        listViewCourses.getItems().clear();
        listViewCourses.getItems().addAll(list_strings);
    }

    @FXML
    public void displayEmail(String email) {
        labelDisplayMail.setText(email);
    }


    public void updateCurrentStudent(Student student) {
        curr_student = student;
        displayEmail(student.getEmail());
    }
}
