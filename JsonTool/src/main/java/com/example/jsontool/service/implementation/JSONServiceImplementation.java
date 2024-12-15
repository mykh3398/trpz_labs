package com.example.jsontool.service.implementation;

import com.example.jsontool.models.JSONSchema;
import com.example.jsontool.models.User;
import com.example.jsontool.repository.JSONRepository;
import com.example.jsontool.repository.UserRepository;
import com.example.jsontool.service.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSONServiceImplementation implements JSONService {
    private JSONRepository jsonRepository;

    @Autowired
    public JSONServiceImplementation(JSONRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    @Override
    public void saveJson(JSONSchema jsonSchema) {

    }
}
