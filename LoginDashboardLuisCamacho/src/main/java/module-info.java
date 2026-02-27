module com.luiscamacho.logindashboard {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.luiscamacho.logindashboard.controllers to javafx.fxml;

    exports com.luiscamacho.logindashboard;
}