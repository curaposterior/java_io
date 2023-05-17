package studentbook.studentbookgui.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmController {
    static boolean answer;

    public static boolean show(String title, String text) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(650);
        Label label = new Label();
        label.setText(text);

        Button yesButton = new Button("Tak");
        Button noButton = new Button("Nie");

        yesButton.setOnAction(e -> {answer = true;
            window.close();});
        noButton.setOnAction(e -> {answer = false;
            window.close();});

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.getChildren().add(yesButton);
        layout.getChildren().add(noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
