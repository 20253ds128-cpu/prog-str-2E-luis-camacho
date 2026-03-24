package com.example.practicaexamenfx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ContactController {

    private String[] arrParentescos = {   "Padre"+
            "Madre"+
            "Hermano"+
            "Hermana"+
            "Abuelo"+
            "Abuela"+
            "Tio"+
            "Tia"};

    @FXML
    private ComboBox<String> arrParentesco;
    private ObservableList<String> listObservableParent = FXCollections.observableArrayList();


    @FXML
    public void initialize () {
        listObservableParent.setAll(arrParentescos);

    }





}
