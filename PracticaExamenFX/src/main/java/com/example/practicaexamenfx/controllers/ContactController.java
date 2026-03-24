package com.example.practicaexamenfx.controllers;

import com.example.practicaexamenfx.model.Contacto;
import com.example.practicaexamenfx.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

private ContactService service = new ContactService();

public class ContactController {

    private String[] arrParentescos = {
            "Padre",
            "Madre",
            "Hermano",
            "Hermana",
            "Abuelo",
            "Abuela",
            "Tio",
            "Tia"
    };


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    private ListView<Contacto> listObservableContacts = FXCollections.observableArrayList();
    private List<Contacto> listContacts = new ArrayList<>();

    @FXML
    private ComboBox<String> cbParentesco;
    private ObservableList<String> listObservableParent = FXCollections.observableArrayList();
    private ObservableList<String> ObservableParent;

    private ContactService service = new ContactService();

    @FXML
    public void initialize () {
        listObservableParent.setAll(arrParentescos);
        cbParentesco.setItems(ObservableParent);
        
    }

    @FXML
    public void onAddContact() {
        String name = txtName.getText().trim();
        String tel = txtTel.getText().trim();

        String parent = cbParentesco.getValue();

        Contacto contact = new Contacto(name,tel,parent);
        service.addContacts(contact);

        listObservableContacts.setAll(service.getAllContacts());


        System.out.println(service.getAllContacts());


    }

}
