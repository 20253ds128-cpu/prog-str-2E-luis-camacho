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
        listContacts.add(contacto);
    }

    public Contacto buscarPorNombre(String nombre) {
        for (Contacto c : listContacts) {
            if (c.getName().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public String actualizarContacto(String nombre, String tel, String parent) {
        Contacto c = buscarPorNombre(nombre);

        if (c == null) {
            return "No encontrado";
        }

        c.setTel(tel);
        c.setParent(parent);

        return null;
    }

    public String eliminarContacto(String nombre) {
        Contacto c = buscarPorNombre(nombre);

        if (c == null) {
            return "No encontrado";
        }

        listContacts.remove(c);
        return null;
    }
}