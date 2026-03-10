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
}
