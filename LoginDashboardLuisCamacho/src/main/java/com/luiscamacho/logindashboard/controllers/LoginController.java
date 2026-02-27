package com.luiscamacho.logindashboard.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {

        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(email.equals("admin") && password.equals("1234")) {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/dashboard.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");

        } else {
            System.out.println("Login incorrecto");
        }
    }
}