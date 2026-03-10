package com.example.demo.controllers;

import com.example.demo.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class AppControllers {

    @FXML
    private Label lblMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload() {
        loadFromFile();
    }

    private void loadFromFile() {

        try {
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados con éxito");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Algo falló" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }
    }
}
