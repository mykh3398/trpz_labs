package com.example.jsontool.service;

import com.example.jsontool.observer.SchemaMetadataSubject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SchemaMetadataServiceImplementation extends SchemaMetadataSubject {
    private final Map<String, String> metadata = new HashMap<>();

    public void updateMetadata(String key, String newValue) {
        metadata.put(key, newValue);
        notifyObservers(key, newValue);
    }

    public String getMetadata(String key) {
        return metadata.get(key);
    }
}
