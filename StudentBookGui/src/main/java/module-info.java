module studentbook.studentbookgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens studentbook.studentbookgui to javafx.fxml;
    exports studentbook.studentbookgui;
}