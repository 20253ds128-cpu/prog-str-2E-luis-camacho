package com.example.practicaexamenfx.controllers;

import com.example.practicaexamenfx.model.Contacto;
import com.example.practicaexamenfx.services.ContactService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cbParentesco;

    @FXML
    private ListView<String> listViewContactos;

    private ContactService service = new ContactService();

    private String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(parentescos);
    }

    @FXML
    public void onAddContact() {
        String nombre = txtNombre.getText();
        String tel = txtTelefono.getText();
        String parent = cbParentesco.getValue();

        if (nombre.isEmpty() || tel.isEmpty() || parent == null) {
            System.out.println("Campos obligatorios");
            return;
        }

        if (tel.length() != 10) {
            System.out.println("Teléfono inválido");
            return;
        }

        if (service.buscarPorNombre(nombre) != null) {
            System.out.println("Ya existe");
            return;
        }

        Contacto c = new Contacto(nombre, tel, parent);
        service.addContacts(c);

        actualizarLista();
        limpiar();
    }

    @FXML
    public void onBuscar() {
        String nombre = txtNombre.getText();

        Contacto c = service.buscarPorNombre(nombre);

        if (c == null) {
            System.out.println("No encontrado");
            return;
        }

        txtTelefono.setText(c.getTel());
        cbParentesco.setValue(c.getParent());
    }

    @FXML
    public void onActualizar() {
        String nombre = txtNombre.getText();
        String tel = txtTelefono.getText();
        String parent = cbParentesco.getValue();

        String res = service.actualizarContacto(nombre, tel, parent);

        if (res != null) {
            System.out.println(res);
        } else {
            actualizarLista();
        }
    }

    @FXML
    public void onEliminar() {
        String nombre = txtNombre.getText();

        String res = service.eliminarContacto(nombre);

        if (res != null) {
            System.out.println(res);
        } else {
            actualizarLista();
            limpiar();
        }
    }

    @FXML
    public void onLimpiar() {
        limpiar();
    }

    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    private void actualizarLista() {
        listViewContactos.getItems().clear();

        for (Contacto c : service.getAllContacts()) {
            listViewContactos.getItems().add(
                    c.getName() + " - " + c.getTel() + " - " + c.getParent()
            );
        }
    }
}