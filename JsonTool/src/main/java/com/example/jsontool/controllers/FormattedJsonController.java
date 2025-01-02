package com.example.jsontool.controllers;

import com.example.jsontool.service.FormattedJsonService;
import com.example.jsontool.service.RawJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formattedJson")
public class FormattedJsonController {
    private FormattedJsonService formattedJsonService;
    @Autowired
    public FormattedJsonController(FormattedJsonService formattedJsonService) {
        this.formattedJsonService = formattedJsonService;
    }
    @PostMapping("/undo")
    public ResponseEntity<String> undoLastFormatted() {
        String json = formattedJsonService.undoFormattedJson();
        return ResponseEntity.ok(json);
    }

    @PostMapping("/redo")
    public ResponseEntity<String> redoLastFormatted() {
        String json = formattedJsonService.redoFormattedJson();
        return ResponseEntity.ok(json);
    }
}
