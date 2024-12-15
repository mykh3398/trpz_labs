package com.example.jsontool.controllers;

import com.example.jsontool.service.JSONService;
import com.example.jsontool.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class JSONController {
    private JSONService jsonService;

    public JSONController(JSONService jsonService) {
        this.jsonService = jsonService;
    }
}
