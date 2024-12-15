package com.example.jsontool.controllers;

import com.example.jsontool.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
}
