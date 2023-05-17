package studentbook.studentbookgui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import studentbook.studentbookgui.Class;
import studentbook.studentbookgui.StartApplication;
import studentbook.studentbookgui.Student;
import studentbook.studentbookgui.StudentCondition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static studentbook.studentbookgui.StartApplication.main_class;

public class TeacherController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;

    @FXML
    private Button btnLogout;

    @FXML
    private ListView<String> listGroups;

    @FXML
    private ListView<String> listStudents;

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = new FXMLLoader(StartApplication.class.getResource("MainScene.fxml"));
        scene = new Scene(root.load());
        stage.close();
        StartApplication.main_stage.setScene(scene);
    }

    public void showGroups(ActionEvent event) {
        List<Class> c = main_class.getGroupsArray();
        List<String> list_strings = new ArrayList<String>();
        for (Class klasa: c) {
            list_strings.add(klasa.getGroupName());
        }
        listGroups.getItems().clear();
        listGroups.getItems().addAll(list_strings);
    }

    @FXML
    public void showStudents(MouseEvent event) {
        // Get the selected group from the listGroups ListView
        String selectedGroup = listGroups.getSelectionModel().getSelectedItem();
        // Update the items of the listStudents ListView based on the selected group
        if (selectedGroup != null) {
            // Get the corresponding Class object for the selected group
            Class selectedClass = main_class.get(selectedGroup);

            if (selectedClass != null) {
                // Get the students of the selected group
                List<Student> students_all = selectedClass.getStudentList();
                List<String> students = new ArrayList<>();
                for (Student st: students_all) {
                    String toadd = st.getName() + " / " + st.getSurname() + ":" + st.getEmail() +", " + st.getCondition();
                    students.add(toadd);
                }

                // Update the items of the listStudents ListView
                ObservableList<String> studentItems = FXCollections.observableArrayList(students);

                listStudents.setItems(studentItems);
            }
        }
    }
}
