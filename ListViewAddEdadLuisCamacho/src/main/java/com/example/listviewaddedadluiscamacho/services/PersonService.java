package com.example.listviewaddedadluiscamacho.services;

import com.example.listviewaddedadluiscamacho.repositories.PersonFileRepository;

import java.io.IOException;
import java.text.NumberFormat;
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
            String edad = parts [2];
            result.add("Nombre: " + name + " - " + email + " - " + edad);
        }

        return result;

    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repo.appendNewLine(name + "," + email + "," + edad);

    }

    private void validate(String name, String email, String edad) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException(": El nombre es incorrecto.");
        }

        String em = (email == null) ? "" : email.trim();

        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException(": El email es incorrecto.");
        }

        try {
            int newNumber = Integer.parseInt(edad);
            if (newNumber < 18 || newNumber > 120) {
                throw new IllegalArgumentException(": Edad inválida");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(": Valor de edad inválido");
        }

    }
}
