package com.example.jsontool.observer;

import org.springframework.stereotype.Component;

@Component
public class MetadataLoggerObserver implements SchemaMetadataObserver {
    @Override
    public void onMetadataUpdated(String key, String newValue) {
        System.out.println("Metadata updated: Key = " + key + ", New Value = " + newValue);
    }
}

