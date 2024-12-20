package com.example.jsontool.service.implementation;

import com.example.jsontool.dto.RegistrationDto;
import com.example.jsontool.models.User;
import com.example.jsontool.repository.UserRepository;
import com.example.jsontool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
