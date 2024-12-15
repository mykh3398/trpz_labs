package com.example.jsontool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonToolApplication.class, args);
    }
    /*
    ------|CONTROLLER|--------
    command ❌ save/format/undo ?
    -------|SERVICE|--------
    strategy ✅ prettify/flat/markdown
    observer ❌ ?
    template method ❌ txt/csv/json ?
    ------|REPOSITORY|--------
    flyweight ❌
     */

}
