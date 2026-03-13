module listviewaddedadluiscamacho {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.listviewaddedadluiscamacho to javafx.fxml;
    opens com.example.listviewaddedadluiscamacho.controllers to javafx.fxml;
    opens com.example.listviewaddedadluiscamacho.services to javafx.fxml;
    opens com.example.listviewaddedadluiscamacho.repositories to javafx.fxml;

    exports com.example.listviewaddedadluiscamacho;
    exports com.example.listviewaddedadluiscamacho.services;
    exports com.example.listviewaddedadluiscamacho.controllers;
    exports com.example.listviewaddedadluiscamacho.repositories;

}