package com.example.practicaexamenfx.services;

import com.example.practicaexamenfx.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contacto> listContacts = new ArrayList<>();

    public List<Contacto> getAllContacts() {
        return listContacts;
    }

    public void addContacts(Contacto contacto) {
        listContacto.add(contacto);
    }

}
