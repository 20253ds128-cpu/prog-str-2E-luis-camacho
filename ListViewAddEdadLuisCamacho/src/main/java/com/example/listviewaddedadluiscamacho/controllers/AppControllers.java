package com.example.listviewaddedadluiscamacho.controllers;

import com.example.listviewaddedadluiscamacho.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.List;

public class AppControllers {

    @FXML
    private Label lblMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    @FXML
    private ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    loadDataToForm(newValue);
                }


        );
        listView.setItems(data);
    }

    @FXML
    public void onReload() {
        loadFromFile();
    }

    @FXML
    public void onAdd() {
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.addPerson(index, name, email, edad);
            lblMsg.setText("Persona creada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos." + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    public void onUpdate() {
        try {
            int index = listView.getSelectionModel().getSelectedIndex();

            if (index == -1) {
                lblMsg.setText("Selecciona un elemento primero");
                lblMsg.setStyle("-fx-text-fill: red");
                return;
            }

            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();

            service.updatePerson(index, name, email, edad);

            lblMsg.setText("Persona actualizada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");

            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();

            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos." + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    public void onDelete() {
        try {
            int index = listView.getSelectionModel().getSelectedIndex();

            if (index == -1) {
                lblMsg.setText("Selecciona un elemento primero");
                lblMsg.setStyle("-fx-text-fill: red");
                return;
            }

            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();

            service.deletePerson(index, name, email, edad);

            lblMsg.setText("Persona eliminada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");

            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();

            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos." + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {

        try {
            List<String> items = service.loadDataForListView();
            data.setAll(items);

        } catch (IOException e) {
            lblMsg.setText("Algo falló" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }
    }

    private void loadDataToForm(String data) {
        String[] parts = data.split(" - ");
        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);
        txtEdad.setText(parts[2]);
    }

}
