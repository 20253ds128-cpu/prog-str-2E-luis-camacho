module com.example.demo_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo_javafx to javafx.fxml;
    exports com.example.demo_javafx;
}