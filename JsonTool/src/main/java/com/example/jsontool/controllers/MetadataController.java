package com.example.jsontool.controllers;

import com.example.jsontool.service.SchemaMetadataServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metadata")
public class MetadataController {
    private final SchemaMetadataServiceImplementation metadataService;

    @Autowired
    public MetadataController(SchemaMetadataServiceImplementation metadataService) {
        this.metadataService = metadataService;
    }

    @PostMapping("/update")
    public String updateMetadata(@RequestParam String key, @RequestParam String value) {
        metadataService.updateMetadata(key, value);
        return "Metadata updated successfully";
    }

    @GetMapping("/get")
    public String getMetadata(@RequestParam String key) {
        return metadataService.getMetadata(key);
    }
}
