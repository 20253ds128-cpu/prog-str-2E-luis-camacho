module com.example.practicaexamenfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamenfx to javafx.fxml;
    exports com.example.practicaexamenfx;
}