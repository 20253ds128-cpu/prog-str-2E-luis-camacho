package com.luiscamacho.logindashboard.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblWelcome;

    public void setUser(String user) {
        lblWelcome.setText("Bienvenido, " + user);
    }
}