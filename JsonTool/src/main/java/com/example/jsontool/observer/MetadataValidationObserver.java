package com.example.jsontool.observer;

import org.springframework.stereotype.Component;

@Component
public class MetadataValidationObserver implements SchemaMetadataObserver {
    @Override
    public void onMetadataUpdated(String key, String newValue) {
        if (newValue.length() > 255){
            System.out.println("Value: " + newValue + "with key: " + key + "must be less then 255 symbols in length");
        }
        System.out.println("Validating metadata for key: " + key);
    }
}
