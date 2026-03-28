module com.example.practicaexamenfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamenfx to javafx.fxml;
    opens com.example.practicaexamenfx.controllers to javafx.fxml;
    opens com.example.practicaexamenfx.model to javafx.fxml;
    opens com.example.practicaexamenfx.services to javafx.fxml;

    exports com.example.practicaexamenfx;
    exports com.example.practicaexamenfx.controllers;
    exports com.example.practicaexamenfx.model;
    exports com.example.practicaexamenfx.services;

}