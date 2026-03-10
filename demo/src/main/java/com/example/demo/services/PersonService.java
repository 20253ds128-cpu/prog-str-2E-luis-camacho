package com.example.demo.services;

import com.example.demo.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();


    public List<String> loadDataForListView() throws IOException {

        List<String> lineas = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line: lineas) {

            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            result.add("Nombre: " + name + " - " + email);
        }

        return result;

    }

    public void addPerson(String name, String email) throws IOException {
        validate(name, email);
        repo.appendNewLine(name + "," + email);

    }

    private void validate(String name, String email) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre es incorrecto.");
        }

        String em = (email == null) ? "" : email.trim();

        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El email es incorrecto.");
        }

    }
}
