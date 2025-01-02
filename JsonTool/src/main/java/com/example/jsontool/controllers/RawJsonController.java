package com.example.jsontool.controllers;
import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.service.RawJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/rawJson")

public class RawJsonController {
    private RawJsonService rawJsonService;
    @Autowired
    public RawJsonController(RawJsonService rawJsonService) {
        this.rawJsonService = rawJsonService;
    }
    @PostMapping("/format/{type}")
    public ResponseEntity<String> formatJson(@RequestBody RawJsonDto rawJsonDto, @PathVariable("type") String type) {
        try {
            String formattedJson = rawJsonService.formatJson(rawJsonDto, type);
            return ResponseEntity.ok(formattedJson);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid JSON input: " + e.getMessage());
        }
    }

}
